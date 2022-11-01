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

    StockService stockService;

    public ProductService(ProductRepository productRepository, StockService stockService) {
        this.productRepository = productRepository;
        this.stockService = stockService;
    }

    @Override
    public Product addProduct(Product product) {
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProductOfStock(Long id) {
        List<Product> products = getAllProducts();
        products = products.stream().filter(productLine ->
                productLine.getStock().getId() == id).toList();


        return products;
    }

    @Override
    public List<Product> getProductOfLocation(Long id) {
        List<Stock> stocks = stockService.getStocks().stream().filter(stock ->
                stock.getLocation().getId() == id).toList();
        List<Product> productList = getAllProducts().stream().filter(product ->
                stocks.contains(product.getStock())).toList();
        return productList;

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

    @Override
    public Integer numberOfProductInStock(Long id) {
        return getProductOfStock(id).size();
    }

    @Override
    public Integer numberOfProductInLocation(Long id) {
        return getProductOfLocation(id).size();
    }
}
