package com.example.product.service.implementation;

import com.example.product.entity.EnumOfProject.LocationStock;
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
        List<Product> productList =new ArrayList<>();
        productList.add(product);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProductOfStock(Stock stock) {
        List<Product> products= productRepository.findAll();
        products=products.stream().filter(productLine ->productLine.getStock().getId()== stock.getId()).toList();


        return products;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        List<Product> productList =new ArrayList<>();
        productList.add(product);
        product.setId(id);
        return productRepository.save(product) ;
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> takeProducts(List<Product> productList) {
        for (Product product :
                productList) {
            product.setComment("Taked by User");
            product.setLocationOfStock(LocationStock.OUT_OF_THE_LOCATION);
            productRepository.save(product);
        }
        return productList;
    }

    @Override
    public List<Product> returnProducts(List<Product> productList) {
        for (Product product :
                productList) {
            product.setComment("Returned by User");
            product.setLocationOfStock(LocationStock.IN_THE_LOCATION);
            productRepository.save(product);

        }
        return productList;
    }


    @Override
    public Void deleteProduct(Long id) {
        List<Product> productList =new ArrayList<>();
        productList.add(productRepository.findById(id).get());
        Product product = productRepository.findById(id).get();
        product.setStateOfProduct(StockState.DESTROYED);
        productRepository.save(product);
        return null;
    }
}
