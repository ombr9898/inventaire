package com.example.product.service.contrat;

import com.example.product.entity.Product;
import com.example.product.entity.Stock;

import java.util.List;
import java.util.Optional;

public interface ProductServiceContrat {
    Product addProduct(Product product);

    List<Product> getProductOfStock(Long id);

    List<Product> getProductOfLocation(Long id);

    Product updateProduct(Long id, Product product);

    Optional<Product> getProduct(Long id);

    List<Product> getAllProducts();


    void deleteProduct(Long id);

    Integer numberOfProductInStock(Long id);

    Integer numberOfProductInLocation(Long id);
}
