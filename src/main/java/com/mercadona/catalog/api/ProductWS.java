package com.mercadona.catalog.api;

import com.mercadona.catalog.pojo.Product;
import com.mercadona.catalog.pojo.ProductCategory;
import com.mercadona.catalog.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Gestion des Web Services des Produits : CRUD de Méthodes Get , Post, Put, Delete
@RestController
@RequestMapping( ApiRegistration.REST_PREFIX + ApiRegistration.REST_CATALOGUE )
public class ProductWS {

    @Autowired    //appel des méthodes ProductService avec autoconfiguration Spring
    private ProductService productService;

    // Map de la méthode Get des produits
    @Operation(operationId = "getAllProducts", summary = "getAllProducts  ( Afficher tous les produits )")
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Map de la méthode Get By (catégorie) des produits
    @Operation(operationId = "getAllProductsByCategory", summary = "getAllProductsByCategory  ( Afficher tous les produits d'une catégorie )")
    @GetMapping("{productCategory}")
    public List<Product> getAllProductsByCategory(@PathVariable(name = "productCategory") ProductCategory productCategory) {
        return productService.getAllProductsByCategory(productCategory);
    }

    // Map de la méthode Post des produits
    @Operation(operationId = "createProduct", summary = "createProduct  ( Créer un nouveau produit )")
    @PostMapping
    public void createProduct(@RequestBody Product product) {
        productService.createProduct(product);
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