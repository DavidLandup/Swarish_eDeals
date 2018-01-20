package com.eDeals.Controller;

import com.eDeals.Model.Product;
import com.eDeals.Service.ProductService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileProductController {
    private java.nio.file.Path path;

    @Autowired
    private ProductService productService;



    @RequestMapping("/product/addProduct")
    public String addProduct(Model model) {

        Product product = new Product();
        product.setProductCategory("Category");
        model.addAttribute("product", product);

        return "addProduct";
    }

    @RequestMapping(value = "/product/addProduct", method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        if(result.hasErrors()) {
            return "addProduct";
        }

        List<Product> productList = productService.getProductList();
        for(Product product1 : productList) {
            if(product.getProductName().equals(product1.getProductName())) {
                return "addProductFail";
            }
        }

        productService.addProduct(product);

        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");

        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\products\\" + product.getId() + ".png");

        if(productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch(Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed!");

            }
        }
        return "redirect:/product/viewProduct/ " + product.getId();
    }

    @RequestMapping("/product/editProduct/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {

        Product product = productService.getProductById(id);


        model.addAttribute("product", product);

        return "editProduct";

    }

    @RequestMapping(value = "/product/editProduct", method = RequestMethod.POST)
    public String editProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request) {

        if(result.hasErrors()) {
            return "editProduct";
        }


        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");

        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\products\\" + product.getId() + ".png");

        if(productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch(Exception e) {
                throw new RuntimeException("Product image saving failed!");
            }
        }

        productService.editProduct(product);
        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/product/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest request){
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");

        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\products\\" + id + ".png");

        if(Files.exists(path)) {
            try {
                Files.delete(path);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        Product product = productService.getProductById(id);
        productService.deleteProduct(product);

        return "redirect:/admin/productInventory";
    }




    @RequestMapping("/product/addScraped")
    public String addScraped(Model model) {

        Product product = new Product();
        product.setProductCategory("Category");
        model.addAttribute("product", product);

        return "addScraped";
    }

    @RequestMapping(value = "/product/addScraped", method = RequestMethod.POST)
    public String addScrapedPost(@Valid @ModelAttribute("product") Product product, @RequestParam("productURL") String string,  BindingResult result, HttpServletRequest request) throws IOException {

        if(result.hasErrors()) {
            return "addScraped";
        }

        List<Product> productList = productService.getProductList();
        for(Product product1 : productList) {
            if(product.getProductName().equals(product1.getProductName())) {
                return "addProductFail";
            }
        }

        Document doc = Jsoup.connect(string).get();
        String title = doc.title();
        product.setProductName(title);

        productService.addProduct(product);

        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");

        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\products\\" + product.getId() + ".png");

        if(productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch(Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed!");

            }
        }
        return "redirect:/product/viewProduct/ " + product.getId();
    }

}
