package com.mercadona.catalog.pojo;

public class Product {
    private Long productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private String imageDirectory;

    private ProductCategory productCategory;
    private Promotion promotion;

    // constructeurs de la classe Produits:
    public Product() {
    }
    public Product(Long productId, String productName, String productDescription, double productPrice, String imageDirectory, ProductCategory productCategory) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.imageDirectory = imageDirectory;
        this.productCategory = productCategory;
    }

    //Getters/Setters du nombre identifiant du Produit:
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    //Getters/Setters du nom (Libellé) du Produit:
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    //Getters/Setters du texte de description du Produit:
    public String getProductDescription() {
        return productDescription;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    //Getters/Setters du prix du Produit:
    public double getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    //Getters/Setters de la direction (chemin absolu du relatif) de l'image du Produit:
    public String getImageDirectory() {
        return imageDirectory;
    }
    public void setImageDirectory(String imageDirectory) {
        this.imageDirectory = imageDirectory;
    }

    //Getters/Setters de la Categorie du Produit:
    public ProductCategory getProductCategory() {
        return productCategory;
    }
    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    //Getters/Setters de la Promotion du Produit (s'il y a une promotion à appliquer):
    public Promotion getPromotion() {
        return promotion;
    }
    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

}
