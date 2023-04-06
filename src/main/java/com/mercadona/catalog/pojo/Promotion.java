package com.mercadona.catalog.pojo;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Promotions")
public class Promotion {
    //Id clé primaire de la base "Promotions" (auto-générée par séquence):
    @Id
    @SequenceGenerator(name="promotion_sequence",
            sequenceName = "promotion_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "promotion_sequence")
    @Column(name = "promotionId", updatable = false)
    private Long promotionId;

    @Column(name = "promotionStartDate")
    private Date promotionStartDate;
    @Column(name = "promotionEndDate")
    private Date promotionEndDate;
    @Column(name = "discountPercentage")
    private int discountPercentage;

    @OneToOne(mappedBy = "promotion")
    private Product product;

    //Constructeurs de la classe Promotion:
    public Promotion() {
        //Constructeur vide requis par Hibernate
    }
    public Promotion(Date promotionStartDate, Date promotionEndDate, int discountPercentage) {
        this.promotionStartDate = promotionStartDate;
        this.promotionEndDate = promotionEndDate;
        this.discountPercentage = discountPercentage;
    }
    public Promotion(Long promotionId, Date promotionStartDate, Date promotionEndDate, int discountPercentage, Product product) {
        this.promotionId = promotionId;
        this.promotionStartDate = promotionStartDate;
        this.promotionEndDate = promotionEndDate;
        this.discountPercentage = discountPercentage;
        this.product = product;
    }

    //Getters/Setters du nombre identifiant de la Promotion:
    public Long getPromotionId() {
        return promotionId;
    }
    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }

    //Getters/Setters de la date de début de Promotion:
    public Date getPromotionStartDate() {
        return promotionStartDate;
    }
    public void setPromotionStartDate(Date promotionStartDate) {
        this.promotionStartDate = promotionStartDate;
    }

    //Getters/Setters de la date de fin de Promotion:
    public Date getPromotionEndDate() {
        return promotionEndDate;
    }
    public void setPromotionEndDate(Date promotionEndDate) {
        this.promotionEndDate = promotionEndDate;
    }

    //Getters/Setters du pourcentage (de remise à appliquer) de la Promotion:
    public int getDiscountPercentage() {
        return discountPercentage;
    }
    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    //Getters/Setters du produit associé à la promotion:
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

}
