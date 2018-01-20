package com.eDeals.Service;


import com.eDeals.Model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProductList();
    Product getProductById(int id);
    List<Product> getProductByCategory(String categoryName);
    List<Product> getProductByPage(int page);
    Long pages();
    List<Product> getProductByCategoryByPage(String categoryName, int page);
    Long pagesByCat(String categoryName);
    void addProduct(Product product);
    void editProduct(Product product);
    void deleteProduct(Product product);
    List<Product> blurrySearch(String title);
    List<Product> getAllProductsForUsername(String username);
}
