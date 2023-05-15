package com.mercadona.catalog.services;

import com.mercadona.catalog.pojo.Product;
import com.mercadona.catalog.pojo.Promotion;

import java.util.List;

public interface PromotionService {

    List<Promotion> getAllPromotions();

    Promotion getPromotionById(Long promotionId);

    void createPromotion(Promotion promotion, Product product);

    void deletePromotion(Long promotionId);

}
