package com.mercadona.catalog.pojo;

import java.util.Date;

public class Promotion {
    private Long promotionId;
    private Date promotionStartDate;
    private Date promotionEndDate;
    private int discountPercentage;

    public Promotion() {
    }
    public Promotion(Long promotionId, Date promotionStartDate, Date promotionEndDate, int discountPercentage) {
        this.promotionId = promotionId;
        this.promotionStartDate = promotionStartDate;
        this.promotionEndDate = promotionEndDate;
        this.discountPercentage = discountPercentage;
    }

    public Long getPromotionId() {
        return promotionId;
    }
    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }

    public Date getPromotionStartDate() {
        return promotionStartDate;
    }
    public void setPromotionStartDate(Date promotionStartDate) {
        this.promotionStartDate = promotionStartDate;
    }

    public Date getPromotionEndDate() {
        return promotionEndDate;
    }
    public void setPromotionEndDate(Date promotionEndDate) {
        this.promotionEndDate = promotionEndDate;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }
    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
