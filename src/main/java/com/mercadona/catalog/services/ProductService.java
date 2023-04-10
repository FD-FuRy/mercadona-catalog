package com.mercadona.catalog.services;

import com.mercadona.catalog.pojo.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long productId);

    void updateProduct(Long productId, Product product);

    void createProduct(Product product);

    void deleteProduct(Long productId);

}
