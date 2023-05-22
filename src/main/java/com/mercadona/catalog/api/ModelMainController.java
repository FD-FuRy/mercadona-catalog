package com.mercadona.catalog.api;

import com.mercadona.catalog.pojo.ProductCategory;
import com.mercadona.catalog.services.ProductCategoryService;
import com.mercadona.catalog.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ModelMainController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;

    // MAP du ModelAndView de la page index.html (avec GetAll de Catégories pour le sélecteur de catégories):
    @GetMapping
    public ModelAndView getCategoriesData() {
        ModelAndView getCategoriesList = new ModelAndView("index.html");
        getCategoriesList.addObject("allCategoriesList", productCategoryService.getAllProductsCategory());
        return getCategoriesList;
    }

    // MAp du ModelAndView de GetAllProductsData du composant getall-products.html:
    @GetMapping("/get/0")
    public ModelAndView getAllProductsData() {
        ModelAndView getAllProductsList = new ModelAndView();
        getAllProductsList.setViewName("components/getall-product.html");
        getAllProductsList.addObject("allProductsList", productService.getAllProducts());
        return getAllProductsList;
    }

    // MAp du ModelAndView de GetAllProductsByCategoryData du composant getall-products.html:
    @GetMapping("/get/{categoryId}")
    public ModelAndView getAllProductsByCategoryData(@PathVariable(name = "categoryId") Long categoryId) {
        ModelAndView getAllProductsByCategoryList = new ModelAndView();
        ProductCategory selectedCategory = productCategoryService.getProductsCategoryById(categoryId);
        getAllProductsByCategoryList.setViewName("components/getall-product.html");
        getAllProductsByCategoryList.addObject("allCategoriesList", productCategoryService.getAllProductsCategory());
        getAllProductsByCategoryList.addObject("allProductsList", productService.getAllProductsByCategory(selectedCategory));
        return getAllProductsByCategoryList;
    }

}
