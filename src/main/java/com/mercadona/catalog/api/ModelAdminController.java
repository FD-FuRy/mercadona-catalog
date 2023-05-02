package com.mercadona.catalog.api;

import com.mercadona.catalog.pojo.Product;
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
@RequestMapping("/admin/")
public class ModelAdminController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;

    // MAP du ModelAndView de la page d'accueil du panneau administrateur:
    @GetMapping
    public ModelAndView getAdminPage() {
        ModelAndView getAdminLandingPage = new ModelAndView();
        getAdminLandingPage.setViewName("pages/admin.html");
        getAdminLandingPage.addObject("allCategoriesList", productCategoryService.getAllProductsCategory());
        getAdminLandingPage.addObject("allProductsList", productService.getAllProducts());
        return getAdminLandingPage;
    }

    // MAp du ModelAndView de GetAllProductsData du composant admin-getall-products.html:
    @GetMapping("/product/get/0")
    public ModelAndView GetAllProductsAdminData() {
        ModelAndView getAllProductsAdminList = new ModelAndView();
        getAllProductsAdminList.setViewName("admin/components/admin-getall-product.html");
        getAllProductsAdminList.addObject("allProductsList", productService.getAllProducts());
        return getAllProductsAdminList;
    }

    // MAp du ModelAndView de GetAllProductsByCategoryData du composant getall-products.html:
    @GetMapping("/product/get/{categoryId}")
    public ModelAndView getAllProductsByCategoryAdminData(@PathVariable(name = "categoryId") Long categoryId) {
        ModelAndView getProductsByCategoryAdminList = new ModelAndView();
        ProductCategory selectedCategory = productCategoryService.getProductsCategoryById(categoryId);
        getProductsByCategoryAdminList.setViewName("admin/components/admin-getall-product.html");
        getProductsByCategoryAdminList.addObject("allCategoriesList", productCategoryService.getAllProductsCategory());
        getProductsByCategoryAdminList.addObject("allProductsList", productService.getAllProductsByCategory(selectedCategory));
        return getProductsByCategoryAdminList;
    }

    //MAP du ModelAndView de la page Admin de création d'un nouveau produit:
    @GetMapping ("/product/create")
    public ModelAndView createProduct() {
        ModelAndView getNewProductData = new ModelAndView();
        getNewProductData.setViewName("admin/create-product.html");
        Product product = new Product();
        getNewProductData.addObject("createdProduct", product);
        getNewProductData.addObject("allCategoriesList", productCategoryService.getAllProductsCategory());
        return getNewProductData;
    }
    //MAP du ModelAndView de la page Admin de modification d'un produit:
    @GetMapping  ("/product/put/{productId}")
    public ModelAndView updateProduct(@PathVariable(name= "productId") Long productId) {
        ModelAndView getProductManagementData = new ModelAndView();
        Product selectedProduct = productService.getProductById(productId);
        getProductManagementData.setViewName("admin/update-product.html");
        getProductManagementData.addObject("toUpdateProduct", selectedProduct);
        getProductManagementData.addObject("allCategoriesList", productCategoryService.getAllProductsCategory());
        return getProductManagementData;
    }

    //MAP du ModelAndView de la page Admin de gestion des catégories:
    @GetMapping ("/category/createdelete")
    public ModelAndView manageCategory() {
        ModelAndView getCategoryManagementData = new ModelAndView();
        getCategoryManagementData.setViewName("admin/createdelete-category.html");
        ProductCategory productCategory = new ProductCategory();
        getCategoryManagementData.addObject("createdCategory", productCategory);
        getCategoryManagementData.addObject("allCategoriesList", productCategoryService.getAllProductsCategory());
        return getCategoryManagementData;
    }

}
