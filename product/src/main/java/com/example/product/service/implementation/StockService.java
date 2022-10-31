package com.example.product.service.implementation;

import com.example.product.entity.EnumOfProject.StockState;
import com.example.product.entity.Product;
import com.example.product.entity.Stock;
import com.example.product.repository.ProductRepository;
import com.example.product.repository.StockRepository;
import com.example.product.service.contrat.StockServiceContrat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockService implements StockServiceContrat {
    StockRepository stockRepository;
    ProductService productService;


    public StockService(StockRepository stockRepository, ProductService productService) {
        this.stockRepository = stockRepository;
        this.productService = productService;
    }

    @Override
    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }


    @Override
    public Optional<Stock> getStock(Long id) {
        return stockRepository.findById(id);
    }

    @Override
    public List<Stock> getStocks() {
        return stockRepository.findAll();
    }


    @Override
    public void deleteStock(Long id) {
        List<Product> products = productService.getAllProducts();
        List<Product> productsOfStock = new ArrayList<>();
        for (Product product : products) {
            System.out.println(product.getId());
            if (product.getStock().getId() == id) {
                product.setStateOfProduct(StockState.DESTROYED);
                productService.addProduct(product);
                productsOfStock.add(product);
            }
        }
        Stock stock = stockRepository.findById(id).get();
        stock.setDeleteStock(Boolean.TRUE);
        stockRepository.save(stock);
    }

    @Override
    public Integer numberOfProductInStock(Long id) {
        Stock stock = stockRepository.findById(id).get();
        System.out.println(stock.getId());
        List<Product> productList = productService.getAllProducts();
        productList = productList.stream().filter(product -> product.getStock().getId() == stock.getId()).toList();
        System.out.println(productList);

        return productList.size();
    }

}
