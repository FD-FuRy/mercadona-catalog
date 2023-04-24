package com.mercadona.catalog.api;

import com.mercadona.catalog.pojo.Product;
import com.mercadona.catalog.services.ProductCategoryService;
import com.mercadona.catalog.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/")
public class ModelAdminControler {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;

    // MAP du ModelAndView de la page d'accueil du panneau administrateur:
    @GetMapping
    public ModelAndView getAdminPage() {
        ModelAndView getAdminLandingPage = new ModelAndView();
        getAdminLandingPage.setViewName("pages/admin.html");
        return getAdminLandingPage;
    }

    //MAP du ModelAndView de la page Admin de création d'un nouveau produit:
    @GetMapping ("/product/create")
    public ModelAndView createProduct() {
        ModelAndView getNewProductData = new ModelAndView();
        getNewProductData.setViewName("/admin/create-product.html");
        Product product = new Product();
        getNewProductData.addObject("product1", product);
        getNewProductData.addObject("allCategoriesList", productCategoryService.getAllProductsCategory());
        return getNewProductData;
    }

}
