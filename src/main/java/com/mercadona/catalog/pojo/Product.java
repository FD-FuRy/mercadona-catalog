package com.mercadona.catalog.pojo;

import jakarta.persistence.*;

@Entity
@Table(name="Products")
public class Product {
    //Id clé primaire de la base "Produits" (auto-générée par séquence):
    @Id
    @SequenceGenerator(name="product_sequence",
    sequenceName = "product_sequence",
    allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "product_sequence")
    @Column(name = "productId", updatable = false)
    private Long productId;

    @Column(name = "productName")
    private String productName;
    @Column(name = "productDescription")
    private String productDescription;
    @Column(name = "productPrice")
    private double productPrice;
    @Column(name = "imageDirectory")
    private String imageDirectory;

    @ManyToOne
    @JoinColumn(name = "categoryId" /* , nullable = false */ )
    private ProductCategory productCategory;
    @OneToOne
    @JoinColumn(name = "promotionId",
            referencedColumnName = "promotionId")
    private Promotion promotion;

    // constructeurs de la classe Produits:
    public Product() {
        //Constructeur vide requis par Hibernate
    }
    public Product(String productName, String productDescription, double productPrice, String imageDirectory, ProductCategory productCategory) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.imageDirectory = imageDirectory;
        this.productCategory = productCategory;
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

    //méthode appelée dans les vues pour afficher le prix recalculé en fonction de la promotion:
    public float calculatePriceWithDiscount(double productPrice, int discountPercentage) {
        float priceWithDiscount;
        int intermediateCalculation;
        double discount;
        // passage par un entier intermédiaire qui sera retransformé en double (pour arrêter à 2 chiffres après la virgule en le redivisant par 100)
        intermediateCalculation = (int)Math.round(productPrice * ((double)discountPercentage / 100) * 100);
        // on obtient un double bloqué à maximum 2 chiffres après la virgule (correspondant au montant de la remise)
        discount = (double)intermediateCalculation / 100;
        // calcul du nouveau prix ( prix produit - montant de la remise )
        priceWithDiscount = (float)(productPrice - discount);
        // retour du nouveau prix calculé
        return priceWithDiscount;
    }

}
