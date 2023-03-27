package com.mercadona.catalog.pojo;

import java.util.Date;

public class Promotion {
    private Long promotionId;
    private Date promotionStartDate;
    private Date promotionEndDate;
    private int discountPercentage;

    //Constructeurs de la classe Promotion:
    public Promotion() {
    }
    public Promotion(Long promotionId, Date promotionStartDate, Date promotionEndDate, int discountPercentage) {
        this.promotionId = promotionId;
        this.promotionStartDate = promotionStartDate;
        this.promotionEndDate = promotionEndDate;
        this.discountPercentage = discountPercentage;
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

}
