package com.mercadona.catalog.services.impl;

import com.mercadona.catalog.pojo.Product;
import com.mercadona.catalog.pojo.Promotion;
import com.mercadona.catalog.repository.PromotionRepository;
import com.mercadona.catalog.services.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;


    @Override
    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    @Override
    public Promotion getPromotionById(Long promotionId) {
        Optional<Promotion> promotionOptional = promotionRepository.findById(promotionId);
        return promotionOptional.orElse(null);
    }

    @Override
    public void updatePromotion(Long promotionId, Promotion promotion) {
        this.deletePromotion(promotionId);
        promotionRepository.save(promotion);
    }

    @Override
    public void createPromotion(Promotion promotion, Product product) {
        promotion.setProduct(product);
        product.setPromotion(promotion);
        promotionRepository.save(promotion);
    }

    @Override
    public void deletePromotion(Long promotionId) {
        promotionRepository.deleteById(promotionId);
    }

}
