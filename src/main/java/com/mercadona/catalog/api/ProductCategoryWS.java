package com.mercadona.catalog.api;

import com.mercadona.catalog.pojo.ProductCategory;
import com.mercadona.catalog.services.ProductCategoryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// Contrôleur des catégories: Gestion des Web Services des Catégories : CRUD de Méthodes Get , Post, Put, Delete
@Controller
@RequestMapping( ApiRegistration.REST_PREFIX + ApiRegistration.REST_CATEGORY )
public class ProductCategoryWS {

    @Autowired      //Instanciation d'un Bean par Spring: appel des méthodes ProductCategoryService avec autoconfiguration
    private ProductCategoryService productCategoryService;

    // Map de la méthode Get By (Id) des catégories
    @Operation(operationId = "getProductsCategoryById", summary = "getProductsCategoryById  ( Afficher une catégorie suivant son Id )")
    @GetMapping("/get/{categoryId}")
    public ProductCategory getProductsCategoryById(@PathVariable(name = "categoryId") Long categoryId) {
        return productCategoryService.getProductsCategoryById(categoryId);
    }

    // Map de la méthode Post des catégories
    @Operation(operationId = "createProductsCategory", summary = "createProductsCategory  ( Créer une nouvelle catégorie de produits )")
    @PostMapping("/post")
    public String createProductsCategory(ProductCategory productCategory) {
        productCategoryService.createProductsCategory(productCategory);
        return "redirect:/admin/category/createdelete?created_category";  //redirection vers le modelandview de la gestion des catégories après la méthode Post du formulaire
    }

    // Map de la méthode Delete des catégories
    @Operation(operationId = "deleteProductsCategory", summary = "deleteProductsCategory  ( Supprimer une catégorie )")
    @RequestMapping (value = "/delete/{categoryId}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteProductsCategory(@PathVariable(name= "categoryId") Long categoryId) {
        productCategoryService.deleteProductsCategory(categoryId);
        return "redirect:/admin/category/createdelete?deleted_category";  //redirection vers le modelandview de la gestion des catégories après la méthode delete
    }

}
