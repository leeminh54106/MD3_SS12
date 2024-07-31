package com.example.categoryproduct.service;

import com.example.categoryproduct.model.Product;

import java.util.List;

public interface IProductService {
    boolean addProduct(Product product);

    void deleteProductById(Integer productId);

    Product findProductById(Integer productId);

    boolean updateProduct(Product product);

    List<Product> searchProduct(String keyword);

    Integer getNewProductId();
}
