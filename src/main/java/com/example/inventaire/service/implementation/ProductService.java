package com.example.inventaire.service.implementation;

import com.example.inventaire.entity.Product;
import com.example.inventaire.entity.Type;
import com.example.inventaire.repository.ProductRepository;
import com.example.inventaire.service.contrat.ProductServiceContrat;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements ProductServiceContrat {

    ProductRepository productRepository;
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        product.setId(id);
        productRepository.save(product);
        return product;
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> getProducts() {

        return productRepository.findAll();
    }

    @Override
    public Void deleteProduct(Long id) {
        productRepository.deleteById(id);
        return null;
    }
}
