package com.mercadona.catalog.services.impl;

import com.mercadona.catalog.pojo.ProductCategory;
import com.mercadona.catalog.services.ProductCategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private static final List<ProductCategory> myProductsCategoryList = new ArrayList<>();

    @Override
    public List<ProductCategory> getAllProductsCategory() {
        return myProductsCategoryList;
    }

    @Override
    public List<ProductCategory> getProductsCategoryById(Long categoryId) {
        return myProductsCategoryList.stream()
                .filter(productCategory -> productCategory.getCategoryId().equals(categoryId))
                .collect(Collectors.toList());
    }

    @Override
    public void updateProductsCategory(Long categoryId, ProductCategory productCategory) {
        myProductsCategoryList.removeIf(myProductCategory -> myProductCategory.getCategoryId().equals(categoryId));
        myProductsCategoryList.add(productCategory);
    }

    @Override
    public void createProductsCategory(ProductCategory productCategory) {
        myProductsCategoryList.add(productCategory);
    }

    @Override
    public void deleteProductsCategory(Long categoryId) {
        myProductsCategoryList.removeIf(myProductCategory -> myProductCategory.getCategoryId().equals(categoryId));
    }

}
