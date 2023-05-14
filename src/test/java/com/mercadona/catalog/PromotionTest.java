package com.mercadona.catalog;

import com.mercadona.catalog.pojo.Product;
import com.mercadona.catalog.pojo.Promotion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PromotionTest {

    LocalDate dateTest = LocalDate.now();

    //test de constructeur vide ( vérification de création d'objet "promotion" (même si vide) ) :
    @Test
    public void testEmptyPromotionConstructor() {
        Promotion promotion = new Promotion();
        assertNotNull(promotion);
    }

    //test de constructeur intermédiaire de "promotions" ( sans ID ) :
    @Test
    public void testNoEmptyPromotionConstructor() {
        Promotion promotion = new Promotion(dateTest , dateTest , 25);
        assertNotNull(promotion);
    }

    //test de constructeur complet de "promotions" ( avec ID désigné) :
    @Test
    public void testCompletePromotionConstructor() {
        Product product = new Product();
        Promotion promotion = new Promotion(9L, dateTest , dateTest , 25, product);
        assertNotNull(promotion);
    }

    //test des Setters et des Getters dans une construction d'objet "promotion" :
    @Test
    public void testPromotionSettersAndGetters() {
        Promotion promotion = new Promotion();
        Product product = new Product();
        product.setProductName("produit test");
        promotion.setPromotionId(8L);
        promotion.setPromotionStartDate(dateTest);
        promotion.setPromotionEndDate(dateTest);
        promotion.setDiscountPercentage(20);
        promotion.setProduct(product);
        assertTrue( (promotion.getPromotionId() == 8) && (promotion.getPromotionStartDate() == dateTest) && (promotion.getPromotionEndDate() == dateTest) && (promotion.getDiscountPercentage() == 20) && (promotion.getProduct().getProductName().equals("produit test")) );
    }


}
