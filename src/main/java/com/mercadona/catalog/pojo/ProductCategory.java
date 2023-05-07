package com.mercadona.catalog.pojo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Prod_Category")
public class ProductCategory {
    //Id clé primaire de la base "Catégories" (auto-générée par séquence):
    @Id
    @SequenceGenerator(name="category_sequence",
            sequenceName = "category_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "category_sequence")
    @Column(name = "categoryId", updatable = false)
    private Long categoryId;

    @Column(name = "categoryName")
    private String categoryName;

    @OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL)
    private List<Product> productList;

    // constructeurs de la classe Categorie des produits:
    public ProductCategory() {
        //constructeur vide requis par Hibernate
    }
    public ProductCategory(String categoryName, List<Product> productList) {
        this.categoryName = categoryName;
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
