package com.example.product.service.implementation;

import com.example.product.entity.EnumOfProject.StockState;
import com.example.product.entity.Product;
import com.example.product.entity.Stock;
import com.example.product.repository.ProductRepository;
import com.example.product.service.contrat.ProductServiceContrat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
        products = products.stream().filter(productLine -> productLine.getStock().getId() == id).toList();


        return products;
    }


    public List<Product> getProductOfLocation(Long id) {
        List<Stock> stocks = stockService.getStocks();
        stocks = stocks.stream().filter(stock -> stock.getLocation().getId() == id).toList();
        List<Product> productList = getAllProducts();
        List productListByLocation = new ArrayList();
        for (Stock stock : stocks
        ) {
            List<Product> product = productList.stream().filter(productLine -> Objects.equals(productLine.getStock().getId(), stock.getId())).toList();
            for (int i = 0; i < product.size(); i++) {
                productListByLocation.add(product.get(i));
            }
        }
        return productListByLocation;

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
        Stock stock = stockService.getStock(id).get();
        List<Product> productList = getAllProducts();
        productList = productList.stream().filter(product -> Objects.equals(product.getStock().getId(), stock.getId())).toList();

        return productList.size();
    }
    @Override
    public Integer numberOfProductInLocation(Long id) {
        List<Stock> stocks = stockService.getStocks();
        stocks = stocks.stream().filter(stock -> stock.getLocation().getId() == id).toList();
        List<Product> productList = getAllProducts();
        List productListByLocation = new ArrayList();

        for (Stock stock : stocks
        ) {
            List<Product> product = productList.stream().filter(productLine -> Objects.equals(productLine.getStock().getId(), stock.getId())).toList();
            for (int i = 0; i < product.size(); i++) {
                productListByLocation.add(product.get(i));
            }
        }
        return productListByLocation.size();
    }
}
