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
import java.util.Objects;
import java.util.Optional;

@Service
public class StockService implements StockServiceContrat {
    StockRepository stockRepository;
    ProductRepository productRepository;

    public StockService(StockRepository stockRepository, ProductRepository productRepository) {
        this.stockRepository = stockRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateStock(Stock stock){
        return stockRepository.save(stock);
    }


    @Override
    public Optional<Stock> getStock(Long id) {

        return stockRepository.findById(id);
    }

    @Override
    public List<Stock> getStocks() {
        List<Stock> stocks=stockRepository.findAll();
        stocks=stocks.stream().filter(stock -> stock.getDeleteStock()==Boolean.FALSE).toList();
        return stocks;
    }


    @Override
    public void deleteStock(Long id) {
        List<Product> products = productRepository.findAll();
        List<Product> productsOfStock = new ArrayList<>();
        for (Product product : products) {
            System.out.println(product.getId());
            if (Objects.equals(product.getStock().getId(), id)) {
                product.setStateOfProduct(StockState.DESTROYED);
                productRepository.save(product);
                productsOfStock.add(product);
            }
        }
        Stock stock = stockRepository.findById(id).get();
        stock.setDeleteStock(Boolean.TRUE);
        stockRepository.save(stock);
    }



}
