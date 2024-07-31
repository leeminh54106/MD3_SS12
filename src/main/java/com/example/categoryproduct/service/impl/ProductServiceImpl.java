package com.example.categoryproduct.service.impl;

import com.example.categoryproduct.model.Product;
import com.example.categoryproduct.service.IProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements IProductService {
    public static final List<Product> products = new ArrayList<>();

    @Override
    public boolean addProduct(Product product) {
        product.setProductId(getNewProductId());
        products.add(product);
        return true;
    }

    @Override
    public List<Product> searchProduct(String keyword) {
        return products.stream().filter(item -> item.getProductName().toLowerCase().contains(keyword.toLowerCase())).toList();
    }

    @Override
    public void deleteProductById(Integer productId) {
        int indexDelete = findIndexProductById(productId);
        products.remove(indexDelete);
    }

    public int findIndexProductById(Integer productId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId().equals(productId)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Product findProductById(Integer productId) {
        if(findIndexProductById(productId) != -1) {
            return products.get(findIndexProductById(productId));
        }
        return null;
    }

    @Override
    public boolean updateProduct(Product product) {
        products.set(findIndexProductById(product.getProductId()), product);
        return true;
    }



    @Override
    public Integer getNewProductId() {
        Integer maxId = 0;
        for (Product product : products) {
            if (product.getProductId() > maxId) {
                maxId = product.getProductId();
            }
        }
        return maxId + 1;
    }
}
