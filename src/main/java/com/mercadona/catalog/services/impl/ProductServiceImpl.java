package com.mercadona.catalog.services.impl;

import com.mercadona.catalog.pojo.Product;
import com.mercadona.catalog.pojo.ProductCategory;
import com.mercadona.catalog.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private static final List<Product> maListe = new ArrayList<>();

    @Override
    public List<Product> getAllProducts() {
        return maListe;
    }

    @Override
    public List<Product> getAllProductsByCategory(ProductCategory productCategory) {
        return maListe.stream()
                .filter(product -> product.getProductCategory().equals(productCategory))
                .collect(Collectors.toList());
    }

    @Override
    public void updateProduct(Long productId, Product product) {
        maListe.removeIf(myProduct -> myProduct.getProductId().equals(productId));
        maListe.add(product);
    }

    @Override
    public void createProduct(Product product) {
        maListe.add(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        maListe.removeIf(myProduct -> myProduct.getProductId().equals(productId));
    }

}
