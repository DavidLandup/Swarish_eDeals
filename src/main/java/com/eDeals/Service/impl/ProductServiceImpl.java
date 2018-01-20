package com.eDeals.Service.impl;


import com.eDeals.DAO.ProductDao;
import com.eDeals.Model.Product;
import com.eDeals.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public Product getProductById(int productId) {
        return productDao.getProductById(productId);

    }

    public List<Product> getProductByCategory(String categoryName) {
        return productDao.getProductByCategory(categoryName);
    }

    public List<Product> getProductByPage(int page) {
        return productDao.getProductByPage(page);
    }

    public Long pages() {
        return productDao.pages();
    }

    public List<Product> getProductByCategoryByPage(String categoryName, int page) {
        return productDao.getProductByCategoryByPage(categoryName, page);
    }


    public Long pagesByCat(String categoryName) {
        return productDao.pagesByCat(categoryName);
    }

    public List<Product> getProductList() {
        return productDao.getProductList();
    }

    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    public void editProduct(Product product) {
        productDao.editProduct(product);
    }

    public void deleteProduct(Product product) {
        productDao.deleteProduct(product);
    }

    public List<Product> blurrySearch(String title) {
        return productDao.blurrySearch(title);
    }

    public List<Product> getAllProductsForUsername(String username) {
        return productDao.getAllProductsForUsername(username);
    }

}
