package com.mercadona.catalog;

import com.mercadona.catalog.api.ModelMainController;
import com.mercadona.catalog.services.ProductCategoryService;
import com.mercadona.catalog.services.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ModelMainControllerTest {

    @Mock
    private ProductCategoryService CategoryService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @Mock
    private ProductService prodService;

    @Autowired ProductService productService;

    @Mock
    private ModelMainController modelController;

    @Autowired
    private ModelMainController modelMainController;


    //test de la vue chargée en retour à l'appel de la méthode getCategoriesData() :
    @Test
    public void testGetCategoriesData() {
        ModelAndView testModelAndView = modelMainController.getCategoriesData();
        assertEquals("index.html", testModelAndView.getViewName() );
    }

    //test de la vue chargée en retour à l'appel de la méthode getAllProductsData() :
    @Test
    public void testGetAllProductsData() {
        ModelAndView testModelAndView = modelMainController.getAllProductsData();
        assertEquals("/components/getall-product.html", testModelAndView.getViewName() );
    }

    //test de la vue chargée en retour à l'appel de la méthode getAllProductsByCategoryData() :
    @Test
    public void testGetAllProductsByCategoryData() {
        ModelAndView testModelAndView = modelMainController.getAllProductsByCategoryData(8L);
        assertEquals("/components/getall-product.html", testModelAndView.getViewName() );
    }

}
