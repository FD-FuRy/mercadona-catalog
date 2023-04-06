package com.mercadona.catalog.pojo;

import java.util.List;

public class ProductCategory {
    private Long categoryId;
    private String categoryName;

    private List<Product> productList;

    // constructeurs de la classe Categorie des produits:
    public ProductCategory() {
    }
    public ProductCategory(String categoryName, List<Product> productList) {
        this.categoryName = categoryName;
        this.productList = productList;
    }
    public ProductCategory(Long categoryId, String categoryName, List<Product> productList) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.productList = productList;
    }

    //Getters/Setters du nombre identifiant de la Categorie:
    public Long getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    //Getters/Setters du nom (libellé) de la Categorie:
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    //Getteres/Setters de la liste de produits de cette catégorie:
    public List<Product> getProductList() {
        return productList;
    }
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
