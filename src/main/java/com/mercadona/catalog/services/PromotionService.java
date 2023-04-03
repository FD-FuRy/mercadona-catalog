package com.mercadona.catalog.services;

import com.mercadona.catalog.pojo.Promotion;

import java.util.List;

public interface PromotionService {

    List<Promotion> getAllPromotions();

    List<Promotion> getPromotionById(Long promotionId);

    void updatePromotion(Long promotionId, Promotion promotion);

    void createPromotion(Promotion promotion);

    void deletePromotion(Long promotionId);

}
