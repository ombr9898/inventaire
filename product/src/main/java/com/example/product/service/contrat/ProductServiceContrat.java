package com.example.product.service.contrat;

import com.example.product.entity.Product;
import com.example.product.entity.Stock;

import java.util.List;
import java.util.Optional;

public interface ProductServiceContrat {
    Product addProduct(Product product);

    List<Product> getProductOfStock(Stock stock);

    Product updateProduct(Long id, Product product);

    Optional<Product> getProduct(Long id);

    List<Product> getAllProducts();

    List<Product> takeProducts(List<Product> productList);

    List<Product> returnProducts(List<Product> productList);

    void deleteProduct(Long id);
}
