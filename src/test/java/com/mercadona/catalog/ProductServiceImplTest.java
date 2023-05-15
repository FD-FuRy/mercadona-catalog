package com.mercadona.catalog;

import com.mercadona.catalog.pojo.Product;
import com.mercadona.catalog.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("ADMIN")
public class ProductServiceImplTest {

    @Autowired
    private ProductRepository productRepository;

    Product product = new Product("test_name", "test_description", 12.55, "https://testdirectory.test", null);

    //Test pour récupérer la liste des produits (si la liste n'est pas nulle) :
    @Test
    public void testGetAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        assertNotNull(allProducts);
    }

    //Test de création de produit :
    @Test
    public void testCreateProduct() {
        productRepository.save(product);

        productRepository.findFirstByProductName("test_name");
        if (productRepository.findFirstByProductName("test_name") != null) {
            Long toEraseIdProduct = productRepository.findFirstByProductName("test_name").getProductId();
            System.out.println("Produit Test créé: L'Id du produit créé avec testCreateProduct() est: " + toEraseIdProduct);
        }
        assertNotNull(productRepository.findFirstByProductName("test_name"));
    }

    //test de suppression de produit :
    @Test
    public void testDeleteProduct() {
        if (productRepository.findFirstByProductName("test_name") != null) {
            Long toEraseIdProduct = productRepository.findFirstByProductName("test_name").getProductId();
            System.out.println("Produit à supprimer présent: Test de suppression de produit en cours...");
            productRepository.deleteById(toEraseIdProduct);
            assertFalse(productRepository.findById(toEraseIdProduct).isPresent());
        } else {
            System.out.println("Produit à supprimer absent: Test impossible, veuillez vérifier le test de création de produit...");
        }
    }

}
