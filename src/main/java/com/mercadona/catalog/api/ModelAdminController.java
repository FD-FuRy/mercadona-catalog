package com.mercadona.catalog.api;

import com.mercadona.catalog.pojo.Product;
import com.mercadona.catalog.pojo.ProductCategory;
import com.mercadona.catalog.pojo.Promotion;
import com.mercadona.catalog.services.ProductCategoryService;
import com.mercadona.catalog.services.ProductService;
import com.mercadona.catalog.services.PromotionService;
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

    @Autowired
    private PromotionService promotionService;

    // MAP du ModelAndView de la page d'accueil du panneau administrateur:
    @GetMapping
    public ModelAndView getAdminPage() {
        ModelAndView getAdminLandingPage = new ModelAndView();
        getAdminLandingPage.setViewName("admin.html");
        getAdminLandingPage.addObject("allCategoriesList", productCategoryService.getAllProductsCategory());
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

    //MAP du ModelAndView de la page Admin de gestion de confirmation de suppression de catégories:
    @GetMapping ("/category/delete-confirm/{categoryId}")
    public ModelAndView manageCategory(@PathVariable(name= "categoryId") Long categoryId) {
        ModelAndView getDeleteCategoryConfirmation = new ModelAndView();
        getDeleteCategoryConfirmation.setViewName("admin/categorydelete-confirm.html");
        getDeleteCategoryConfirmation.addObject("selectedCategory", productCategoryService.getProductsCategoryById(categoryId));
        return getDeleteCategoryConfirmation;
    }

    //MAP du ModelAndView de la page Admin de création d'une promotion:
    @GetMapping ("/promotion/create/{productId}")
    public ModelAndView createPromotion(@PathVariable(name= "productId") Long productId) {
        ModelAndView getNewPromotionData = new ModelAndView();
        getNewPromotionData.setViewName("admin/create-promotion.html");
        Promotion promotion = new Promotion();
        promotion.setProduct(productService.getProductById(productId));
        getNewPromotionData.addObject("createdPromotion", promotion);
        getNewPromotionData.addObject("selectedProduct", productService.getProductById(productId));
        return getNewPromotionData;
    }

    //MAP du ModelAndView de la page Admin d'affichage des promotions:
    @GetMapping ("/promotion/manage")
    public ModelAndView managePromotions() {
        ModelAndView getAllPromotionsList = new ModelAndView();
        getAllPromotionsList.setViewName("admin/watchdelete-promotion.html");
        getAllPromotionsList.addObject("allPromotionsList", promotionService.getAllPromotions());
        return getAllPromotionsList;
    }

}
