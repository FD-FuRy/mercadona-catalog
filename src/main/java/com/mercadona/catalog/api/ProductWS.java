package com.mercadona.catalog.api;

import com.mercadona.catalog.pojo.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Gestion des Web Services des Produits : Méthodes Get , Post, Put, Delete
@RestController
@RequestMapping( ApiRegistration.REST_PREFIX + ApiRegistration.REST_CATALOGUE )
public class ProductWS {

    // Map de la méthode Get des produits
    @GetMapping
    public List<Product> getAllProducts() {
        return null;   // implémentation de la méthode Get des produits ici
    }

    // Map de la méthode Post des produits
    @PostMapping
    public void createProduct(@RequestBody Product product) {
        // implémentation de la méthode Post ici
    }

    // Map de la méthode Put des produits
    @PutMapping("{name}")
    public void updateProduct(@PathVariable(name= "name") String nom) {
        // implémentation de la méthode Put ici
    }

    // Map de la méthode Delete des produits
    @DeleteMapping ("{name}")
    public void deleteProduct(@PathVariable(name= "name") String nom) {
        // implémentation de la méthode Delete ici
    }

}
