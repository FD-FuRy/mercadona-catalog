package com.mercadona.catalog.services.impl;

import com.mercadona.catalog.pojo.Promotion;
import com.mercadona.catalog.services.PromotionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromotionServiceImpl implements PromotionService {

    private static final List<Promotion> myPromotionsList = new ArrayList<>();


    @Override
    public List<Promotion> getAllPromotions() {
        return myPromotionsList;
    }

    @Override
    public List<Promotion> getPromotionById(Long promotionId) {
        return myPromotionsList.stream()
                .filter(promotion -> promotion.getPromotionId().equals(promotionId))
                .collect(Collectors.toList());
    }

    @Override
    public void updatePromotion(Long promotionId, Promotion promotion) {
        myPromotionsList.removeIf(myPromotions -> myPromotions.getPromotionId().equals(promotionId));
        myPromotionsList.add(promotion);
    }

    @Override
    public void createPromotion(Promotion promotion) {
        myPromotionsList.add(promotion);
    }

    @Override
    public void deletePromotion(Long promotionId) {
        myPromotionsList.removeIf(myPromotions -> myPromotions.getPromotionId().equals(promotionId));
    }
}
