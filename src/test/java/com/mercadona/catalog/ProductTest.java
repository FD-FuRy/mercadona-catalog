package com.mercadona.catalog;

import com.mercadona.catalog.pojo.Product;
import com.mercadona.catalog.pojo.ProductCategory;
import com.mercadona.catalog.pojo.Promotion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductTest {

    //test de constructeur vide de "produits" ( vérification de création d'objet (même si vide) ) :
    @Test
    public void testEmptyProductConstructor() {
        Product product = new Product();
        assertNotNull(product);
    }

    //test de constructeur intermédiaire de "produits" ( sans ID ) :
    @Test
    public void testNoEmptyProductConstructor() {
        Product product = new Product("Produit Test Nom", "Produit Test Description", 5.55, "https://image-directory.test", null);
        assertNotNull(product);
    }

    //test du constructeur complet de "produits" ( avec ID désigné ) :
    @Test
    public void testCompleteProductConstructor() {
        Product product = new Product(13L,"Produit Test Nom", "Produit Test Description", 5.55, "https://image-directory.test", null);
        assertNotNull(product);
    }

    //test des Setters et des Getters dans une construction d'objet "produit" :
    @Test
    public void testProductSettersAndGetters() {
        Product product = new Product();
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(1L);
        Promotion promotion = new Promotion();
        promotion.setDiscountPercentage(20);
        product.setProductId(69L);
        product.setProductName("test nom de produit");
        product.setProductDescription("test description");
        product.setProductPrice(8.75);
        product.setImageDirectory("https://test.com");
        product.setProductCategory(productCategory);
        product.setPromotion(promotion);
        assertTrue( (product.getProductId() == 69) && (product.getProductName().equals("test nom de produit")) && (product.getProductDescription().equals("test description")) && (product.getProductPrice() == 8.75) && (product.getImageDirectory().equals("https://test.com")) && (product.getProductCategory().getCategoryId() != null) && (product.getPromotion().getDiscountPercentage() == 20) );
    }

    @Test
    public void testCalculatePriceWithDiscount() {
        Product product = new Product();
        Promotion promotion = new Promotion();
        promotion.setDiscountPercentage(20);
        product.setProductPrice(22.50);
        product.setPromotion(promotion);
        assertEquals( 18 , product.calculatePriceWithDiscount(product.getProductPrice(), product.getPromotion().getDiscountPercentage()));

    }

}
