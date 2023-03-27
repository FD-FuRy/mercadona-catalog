package com.mercadona.catalog.pojo;

public class Product {
    private Long productId;
    private String productName;
    private double productPrice;
    private String imageDirectory;

    private ProductCategory productCategory;
    private Promotion promotion;

    public Product() {
    }
    public Product(Long productId, String productName, double productPrice, String imageDirectory, ProductCategory productCategory) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.imageDirectory = imageDirectory;
        this.productCategory = productCategory;
    }

    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getImageDirectory() {
        return imageDirectory;
    }
    public void setImageDirectory(String imageDirectory) {
        this.imageDirectory = imageDirectory;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }
    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public Promotion getPromotion() {
        return promotion;
    }
    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

}
