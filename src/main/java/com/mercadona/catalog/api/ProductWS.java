package com.mercadona.catalog.api;

import com.mercadona.catalog.pojo.Product;
import com.mercadona.catalog.services.ProductService;
import com.mercadona.catalog.services.PromotionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// Contrôleur des produits: Gestion des Web Services des Produits : CRUD de Méthodes Get , Post, Put, Delete
@Controller
@RequestMapping( ApiRegistration.REST_PREFIX + ApiRegistration.REST_PRODUCT )
public class ProductWS {

    @Autowired    //Instanciation d'un Bean par Spring: appel des méthodes ProductService avec autoconfiguration
    private ProductService productService;

    @Autowired    //Instanciation d'un Bean par Spring: appel des méthodes PromotionService avec autoconfiguration
    private PromotionService promotionService;

    // Map de la méthode Get By (Id) des produits
    @Operation(operationId = "getProductById", summary = "getProductById  ( Afficher un produit suivant son Id )")
    @GetMapping("/get/{productId}")
    public Product getProductById(@PathVariable(name = "productId") Long productId) {
        return productService.getProductById(productId);
    }

    // Map de la méthode Post des produits
    @Operation(operationId = "createProduct", summary = "createProduct  ( Créer un nouveau produit )")
    @PostMapping("/post")
    public String createProduct(Product product) {
        productService.createProduct(product);
        return "redirect:/admin/?created_product";  //redirection vers le modelandview de création de produit après la méthode Post du formulaire
    }

    // Map de la méthode Put des produits
    @Operation(operationId = "updateProduct", summary = "updateProduct  ( Modifier un produit existant )")
    @RequestMapping (value ="/put/{productId}", method = {RequestMethod.PUT, RequestMethod.POST})
    public String updateProduct(@PathVariable(name= "productId") Long productId, Product product) {
        productService.updateProduct(productId, product);
        return "redirect:/admin/?updated_product";  //redirection vers le modelandview de la page d'accueil du panneau admin
    }

    // Map de la méthode Delete des produits
    @Operation(operationId = "deleteProduct", summary = "deleteProduct  ( Supprimer un produit )")
    @RequestMapping (value ="/delete/{productId}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteProduct(@PathVariable(name= "productId") Long productId) {
        if (productService.getProductById(productId).getPromotion() == null) {
            productService.deleteProduct(productId);
            return "redirect:/admin/?deleted_product";  //redirection vers le modelandview de la page d'accueil du panneau admin
        }   else {
            promotionService.deletePromotion(productService.getProductById(productId).getPromotion().getPromotionId());
            productService.deleteProduct(productId);
            return "redirect:/admin/?deleted_product";  //redirection vers le modelandview de la page d'accueil du panneau admin
        }
    }

}