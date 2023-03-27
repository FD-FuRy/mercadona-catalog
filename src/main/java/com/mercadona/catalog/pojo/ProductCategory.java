package com.mercadona.catalog.pojo;

public class ProductCategory {
    private Long categoryId;
    private String categoryName;

    // constructeurs de la classe Categorie des produits:
    public ProductCategory() {
    }
    public ProductCategory(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
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

}
