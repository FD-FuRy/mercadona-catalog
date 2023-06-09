package com.mercadona.catalog.services.impl;

import com.mercadona.catalog.pojo.Product;
import com.mercadona.catalog.pojo.ProductCategory;
import com.mercadona.catalog.repository.ProductRepository;
import com.mercadona.catalog.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllProductsByCategory(ProductCategory productCategory) {
        return productRepository.findAllByProductCategory(productCategory);
    }

    @Override
    public Product getProductById(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        return productOptional.orElse(null);
    }

    @Override
    public void updateProduct(Long productId, Product product) {
        this.getProductById(productId).setProductName(product.getProductName());
        this.getProductById(productId).setProductDescription(product.getProductDescription());
        this.getProductById(productId).setProductPrice(product.getProductPrice());
        this.getProductById(productId).setImageDirectory(product.getImageDirectory());
        this.getProductById(productId).setProductCategory(product.getProductCategory());
        if (product.getPromotion() != null) {    //récupération de la promo (si promo il y avait) :
            this.getProductById(productId).setPromotion(getProductById(productId).getPromotion());
        }
        productRepository.save(this.getProductById(productId));
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

}
