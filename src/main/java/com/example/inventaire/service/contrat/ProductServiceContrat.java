package com.example.inventaire.service.contrat;

import com.example.inventaire.entity.Product;

import java.util.List;

public interface ProductServiceContrat {

    Product addProduct(Product product);
    Product updateProduct(Long id,Product product);
    Product getProduct(Long id);
    List<Product> getProducts();
    Void deleteProduct(Long id);
}

