package com.example.product.service.implementation;

import com.example.product.entity.EnumOfProject.StockState;
import com.example.product.entity.Product;
import com.example.product.entity.Stock;
import com.example.product.repository.ProductRepository;
import com.example.product.service.contrat.ProductServiceContrat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceContrat {
    ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Product product) {
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProductOfStock(Stock stock) {
        List<Product> products = getAllProducts();
        products = products.stream().filter(productLine -> productLine.getStock().getId() == stock.getId()).toList();


        return products;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getAllProducts() {

        List<Product> products = productRepository.findAll();
        products = products.stream().filter(product -> product.getStateOfProduct() == StockState.OK).toList();
        return products;
    }


    @Override
    public void deleteProduct(Long id) {
        List<Product> productList = new ArrayList<>();
        productList.add(productRepository.findById(id).get());
        Product product = productRepository.findById(id).get();
        product.setStateOfProduct(StockState.DESTROYED);
        productRepository.save(product);
    }
}
