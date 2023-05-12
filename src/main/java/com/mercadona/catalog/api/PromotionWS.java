package com.mercadona.catalog.api;

import com.mercadona.catalog.pojo.Product;
import com.mercadona.catalog.pojo.Promotion;
import com.mercadona.catalog.services.ProductService;
import com.mercadona.catalog.services.PromotionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Contrôleur des promotions: Gestion des Web Services des Promotions : CRUD de Méthodes Get , Post, Put, Delete
@Controller
@RequestMapping( ApiRegistration.REST_PREFIX + ApiRegistration.REST_PROMOTION )
public class PromotionWS {

    @Autowired      //Instanciation d'un Bean par Spring: appel des méthodes PromotionService avec autoconfiguration
    private PromotionService promotionService;

    @Autowired      //Instanciation d'un Bean par Spring: appel des méthodes PromotionService avec autoconfiguration
    private ProductService productService;

    // Map de la méthode Get All des promotions
    @Operation(operationId = "getAllPromotions", summary = "getAllPromotions  ( Afficher toutes les promotions)")
    @GetMapping
    public List<Promotion> getAllPromotions() {
        return promotionService.getAllPromotions();
    }

    // Map de la méthode Get By (Id) des promotions
    @Operation(operationId = "getPromotionById", summary = "getPromotionById  ( Afficher les promotions suivant leur Id )")
    @GetMapping("/get/{promotionId}")
    public Promotion getPromotionById(@PathVariable(name = "promotionId") Long promotionId) {
        return promotionService.getPromotionById(promotionId);
    }

    // Map de la méthode Post des promotions
    @Operation(operationId = "createPromotion", summary = "createPromotion  ( Créer une nouvelle promotion )")
    @PostMapping ("/post/{productId}")
    public String createPromotion(Promotion promotion, @PathVariable(name = "productId") Product product) {
        promotionService.createPromotion(promotion, product);
        return "redirect:/admin/?created_promotion";  //redirection vers le modelandview de la page d'accueil du panneau admin
    }

    // Map de la méthode Put des promotions
    @Operation(operationId = "updatePromotion", summary = "updatePromotion  ( Modifier une promotion existante )")
    @PutMapping("/put/{promotionId}")
    public void updatePromotion(@PathVariable(name = "promotionId") Long promotionId, Promotion promotion) {
        promotionService.updatePromotion(promotionId, promotion);
    }

    // Map de la méthode Delete des promotions
    @Operation(operationId = "deletePromotion", summary = "deletePromotion  ( Supprimer une promotion )")
    @RequestMapping (value ="/delete/{promotionId}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deletePromotion(@PathVariable(name = "promotionId") Long promotionId) {
        Product oldProduct = new Product();
        Boolean productInside;
        if (promotionService.getPromotionById(promotionId).getProduct() != null) {
            oldProduct = productService.getProductById(promotionService.getPromotionById(promotionId).getProduct().getProductId());
            oldProduct.setPromotion(null);
            productInside = true;
        }   else {
            productInside = false;
        }
        promotionService.deletePromotion(promotionId);
        if (productInside) {
            productService.createProduct(oldProduct);
        }
        return "redirect:/admin/?deleted_promotion";
    }

}
