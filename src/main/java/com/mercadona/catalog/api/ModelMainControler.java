package com.mercadona.catalog.api;

import com.mercadona.catalog.services.ProductCategoryService;
import com.mercadona.catalog.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ModelMainControler {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;

    // MAP du ModelAndView de la page index.html (avec GetAll pour les Objets Produits et Catégories):
    @GetMapping
    public ModelAndView getAllProductsData() {
        ModelAndView getAllProductsList = new ModelAndView("index.html");
        getAllProductsList.addObject("allProductsList", productService.getAllProducts());
        getAllProductsList.addObject("allCategoriesList", productCategoryService.getAllProductsCategory());
        return getAllProductsList;
    }

}
