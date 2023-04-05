package com.mercadona.catalog.api;

import com.mercadona.catalog.pojo.Promotion;
import com.mercadona.catalog.services.PromotionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Contrôleur des promotions: Gestion des Web Services des Promotions : CRUD de Méthodes Get , Post, Put, Delete
@RestController
@RequestMapping( ApiRegistration.REST_PREFIX + ApiRegistration.REST_PROMOTION )
public class PromotionWS {

    @Autowired      //Instanciation d'un Bean par Spring: appel des méthodes PromotionService avec autoconfiguration
    private PromotionService promotionService;

    // Map de la méthode Get All des promotions
    @Operation(operationId = "getAllPromotions", summary = "getAllPromotions  ( Afficher toutes les promotions)")
    @GetMapping
    public List<Promotion> getAllPromotions() {
        return promotionService.getAllPromotions();
    }

    // Map de la méthode Get By (Id) des promotions
    @Operation(operationId = "getPromotionById", summary = "getPromotionById  ( Afficher les promotions suivant leur Id )")
    @GetMapping("{promotionId}")
    public List<Promotion> getPromotionById(@PathVariable(name = "promotionId") Long promotionId) {
        return promotionService.getPromotionById(promotionId);
    }

    // Map de la méthode Post des promotions
    @Operation(operationId = "createPromotion", summary = "createPromotion  ( Créer une nouvelle promotion )")
    @PostMapping
    public void createPromotion(@RequestBody Promotion promotion) {
        promotionService.createPromotion(promotion);
    }

    // Map de la méthode Put des promotions
    @Operation(operationId = "updatePromotion", summary = "updatePromotion  ( Modifier une promotion existante )")
    @PutMapping("{promotionId}")
    public void updatePromotion(@PathVariable(name = "promotionId") Long promotionId,
                                @RequestBody Promotion promotion) {
        promotionService.updatePromotion(promotionId, promotion);
    }

    // Map de la méthode Delete des promotions
    @Operation(operationId = "deletePromotion", summary = "deletePromotion  ( Supprimer une promotion )")
    @DeleteMapping("{promotionId}")
    public void deletePromotion(@PathVariable(name = "promotionId") Long promotionId) {
        promotionService.deletePromotion(promotionId);
    }

}
