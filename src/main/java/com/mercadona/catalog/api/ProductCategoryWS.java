package com.mercadona.catalog.api;

import com.mercadona.catalog.pojo.ProductCategory;
import com.mercadona.catalog.services.ProductCategoryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Contrôleur des catégories: Gestion des Web Services des Catégories : CRUD de Méthodes Get , Post, Put, Delete
@RestController
@RequestMapping( ApiRegistration.REST_PREFIX + ApiRegistration.REST_CATEGORY )
public class ProductCategoryWS {

    @Autowired      //Instanciation d'un Bean par Spring: appel des méthodes ProductCategoryService avec autoconfiguration
    private ProductCategoryService productCategoryService;

    // Map de la méthode Get All des catégories
    @Operation(operationId = "getAllProductsCategory", summary = "getAllProductsCategory  ( Afficher toutes les catégories de produits)")
    @GetMapping
    public List<ProductCategory> getAllProductsCategory() {
        return productCategoryService.getAllProductsCategory();
    }

    // Map de la méthode Get By (Id) des catégories
    @Operation(operationId = "getProductsCategoryById", summary = "getProductsCategoryById  ( Afficher catégories suivant leur Id )")
    @GetMapping("{categoryId}")
    public List<ProductCategory> getProductsCategoryById(@PathVariable(name = "categoryId") Long categoryId) {
        return productCategoryService.getProductsCategoryById(categoryId);
    }

    // Map de la méthode Post des catégories
    @Operation(operationId = "createProductsCategory", summary = "createProductsCategory  ( Créer une nouvelle catégorie de produits )")
    @PostMapping
    public void createProductsCategory(@RequestBody ProductCategory productCategory) {
        productCategoryService.createProductsCategory(productCategory);
    }

    // Map de la méthode Put des catégories
    @Operation(operationId = "updateProductsCategory", summary = "updateProductsCategory  ( Modifier une catégorie existante )")
    @PutMapping("{categoryId}")
    public void updateProductsCategory(@PathVariable(name = "categoryId") Long categoryId,
                                       @RequestBody ProductCategory productCategory) {
        productCategoryService.updateProductsCategory(categoryId, productCategory);
    }

    // Map de la méthode Delete des catégories
    @Operation(operationId = "deleteProductsCategory", summary = "deleteProductsCategory  ( Supprimer une catégorie )")
    @DeleteMapping("{categoryId}")
    public void deleteProductsCategory(@PathVariable(name= "categoryId") Long categoryId) {
        productCategoryService.deleteProductsCategory(categoryId);
    }

}
