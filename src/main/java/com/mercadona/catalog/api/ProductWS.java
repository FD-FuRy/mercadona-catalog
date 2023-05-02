package com.mercadona.catalog.api;

import com.mercadona.catalog.pojo.Product;
import com.mercadona.catalog.pojo.ProductCategory;
import com.mercadona.catalog.services.ProductCategoryService;
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

    @Autowired    //Instanciation d'un Bean par Spring: appel des méthodes ProductCategoryService avec autoconfiguration
    private ProductCategoryService productCategoryService;

    // Map de la méthode Get des produits
    @Operation(operationId = "getAllProducts", summary = "getAllProducts  ( Afficher tous les produits )")
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Map de la méthode Get By (Id) des produits
    @Operation(operationId = "getProductById", summary = "getProductById  ( Afficher un produit suivant son Id )")
    @GetMapping("/get/{productId}")
    public Product getProductById(@PathVariable(name = "productId") Long productId) {
        return productService.getProductById(productId);
    }

    //MAP de la méthode Get By (catégorie) des produits
    @GetMapping("/get/{categoryId}")
    public List<Product> getAllProductsByCategory(@PathVariable(name = "categoryId") Long categoryId) {
        ProductCategory selectedCategory = productCategoryService.getProductsCategoryById(categoryId);
        return productService.getAllProductsByCategory(selectedCategory);
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
    @RequestMapping (value ="/put/{productId}", method = {RequestMethod.PUT, RequestMethod.POST})
    public String updateProduct(@PathVariable(name= "productId") Long productId, Product product) {
        productService.updateProduct(productId, product);
        return "redirect:/admin/";  //redirection vers le modelandview de la page d'accueil du panneau admin
    }

    // Map de la méthode Delete des produits
    @Operation(operationId = "deleteProduct", summary = "deleteProduct  ( Supprimer un produit )")
    @RequestMapping (value ="/delete/{productId}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteProduct(@PathVariable(name= "productId") Long productId) {
        productService.deleteProduct(productId);
        return "redirect:/admin/";  //redirection vers le modelandview de la page d'accueil du panneau admin
    }

}