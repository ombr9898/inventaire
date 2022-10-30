package com.example.product.service.contrat;

import com.example.product.entity.Product;
import com.example.product.entity.Stock;

import java.util.List;

public interface ProductServiceContrat {
    Product addProduct(Product product);
    List<Product> getProductOfStock(Stock stock);
    Product updateProduct(Long id, Product product);
    Product getProduct(Long id);
    List<Product> getAllProducts();
    List<Product> takeProducts(List<Product> productList);
    List<Product> returnProducts(List<Product> productList);
    Void deleteProduct(Long id);
}
