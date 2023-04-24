package com.mercadona.catalog.api;

import com.mercadona.catalog.pojo.Product;
import com.mercadona.catalog.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Contrôleur des produits: Gestion des Web Services des Produits : CRUD de Méthodes Get , Post, Put, Delete
@Controller
@RequestMapping( ApiRegistration.REST_PREFIX + ApiRegistration.REST_PRODUCT )
public class ProductWS {

    @Autowired    //Instanciation d'un Bean par Spring: appel des méthodes ProductService avec autoconfiguration
    private ProductService productService;

    // Map de la méthode Get des produits
    @Operation(operationId = "getAllProducts", summary = "getAllProducts  ( Afficher tous les produits )")
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Map de la méthode Get By (Id) des produits
    @Operation(operationId = "getProductById", summary = "getProductById  ( Afficher un produit suivant son Id )")
    @GetMapping("{productId}")
    public Product getProductById(@PathVariable(name = "productId") Long productId) {
        return productService.getProductById(productId);
    }

    // Map de la méthode Post des produits
    @Operation(operationId = "createProduct", summary = "createProduct  ( Créer un nouveau produit )")
    @PostMapping("/post")
    public String createProduct(Product product) {
        productService.createProduct(product);
        return "redirect:/admin/product/create";  //redirection vers le modelandview de création de produit après la méthode Post du formulaire
    }

    // Map de la méthode Put des produits
    @Operation(operationId = "updateProduct", summary = "updateProduct  ( Modifier un produit existant )")
    @PutMapping("{productId}")
    public void updateProduct(@PathVariable(name= "productId") Long productId,
                              @RequestBody Product product) {
        productService.updateProduct(productId, product);
    }

    // Map de la méthode Delete des produits
    @Operation(operationId = "deleteProduct", summary = "deleteProduct  ( Supprimer un produit )")
    @DeleteMapping ("{productId}")
    public void deleteProduct(@PathVariable(name= "productId") Long productId) {
        productService.deleteProduct(productId);
    }

}