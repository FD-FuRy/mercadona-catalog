package com.mercadona.catalog.services;

import com.mercadona.catalog.pojo.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategory> getAllProductsCategory();

    List<ProductCategory> getProductsCategoryById(Long categoryId);

    void updateProductsCategory(Long categoryId, ProductCategory productCategory);

    void createProductsCategory(ProductCategory productCategory);

    void deleteProductsCategory(Long categoryId);

}
