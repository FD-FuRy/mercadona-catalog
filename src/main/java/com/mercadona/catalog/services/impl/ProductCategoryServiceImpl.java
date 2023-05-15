package com.mercadona.catalog.services.impl;

import com.mercadona.catalog.pojo.ProductCategory;
import com.mercadona.catalog.repository.ProductCategoryRepository;
import com.mercadona.catalog.services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> getAllProductsCategory() {
        return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategory getProductsCategoryById(Long categoryId) {
        Optional<ProductCategory> productCategoryOptional = productCategoryRepository.findById(categoryId);
        return productCategoryOptional.orElse(null);
    }

    @Override
    public void createProductsCategory(ProductCategory productCategory) {
        productCategoryRepository.save(productCategory);
    }

    @Override
    public void deleteProductsCategory(Long categoryId) {
        productCategoryRepository.deleteById(categoryId);
    }

}
