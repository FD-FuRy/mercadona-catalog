package com.mercadona.catalog.services.impl;

import com.mercadona.catalog.pojo.Product;
import com.mercadona.catalog.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private static final List<Product> myProductsList = new ArrayList<>();

    @Override
    public List<Product> getAllProducts() {
        return myProductsList;
    }

    @Override
    public List<Product> getProductsById(Long productId) {
        return myProductsList.stream()
                .filter(product -> product.getProductId().equals(productId))
                .collect(Collectors.toList());
    }

    @Override
    public void updateProduct(Long productId, Product product) {
        myProductsList.removeIf(myProduct -> myProduct.getProductId().equals(productId));
        myProductsList.add(product);
    }

    @Override
    public void createProduct(Product product) {
        myProductsList.add(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        myProductsList.removeIf(myProduct -> myProduct.getProductId().equals(productId));
    }

}
