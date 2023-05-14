package com.mercadona.catalog;

import com.mercadona.catalog.pojo.Product;
import com.mercadona.catalog.pojo.ProductCategory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ProductCategoryTest {

    //test de constructeur vide ( vérification de création d'objet "catégorie" (même si vide) ) :
    @Test
    public void testEmptyProductCategoryConstructor() {
        ProductCategory productCategory = new ProductCategory();
        assertNotNull(productCategory);
    }

    //test de constructeur intermédiaire de "catégories" ( sans ID ) :
    @Test
    public void testNoEmptyProductConstructor() {
        ProductCategory productCategory = new ProductCategory("Nom de catégorie Test", null);
        assertNotNull(productCategory);
    }

    //test du constructeur complet de "catégories" ( avec ID désigné ) :
    @Test
    public void testCompleteProductConstructor() {
        List<Product> productListTest = new ArrayList<>();
        ProductCategory productCategory = new ProductCategory(11L, "Nom de catégorie Test", productListTest);
        assertNotNull(productCategory);
    }

    //test des Setters et des Getters dans une construction d'objet "catégorie" :
    @Test
    public void testCategorySettersAndGetters() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(10L);
        productCategory.setCategoryName("test nom de catégorie");
        productCategory.setProductList(new ArrayList<>());
        assertTrue( (productCategory.getCategoryId() == 10) && (productCategory.getCategoryName().equals("test nom de catégorie")) && (productCategory.getProductList().isEmpty()));
    }







}
