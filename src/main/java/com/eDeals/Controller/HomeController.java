package com.eDeals.Controller;

import com.eDeals.Model.Product;
import com.eDeals.Model.Profile;
import com.eDeals.Service.ProductService;
import com.eDeals.Service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProfileService profileService;

    @Autowired
    ProductService productService;

    ConnectController connectController;


    @RequestMapping("/")
    public String home(Model model) {
        List<Profile> profileList = profileService.getAllProfiles();
        model.addAttribute("profileList", profileList);

        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);
        return "home";
    }



    @RequestMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout, Model model) {

        if (error != null) {
            model.addAttribute("error", "Wrong username or password!");
        }

        if (logout != null) {
            model.addAttribute("msg", "You have successfully logged out!");
        }

        return "login";
    }




}
