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
    public Stock getStock(Long id) {
        return stockRepository.findById(id).get();
    }

    @Override
    public List<Stock> getStocks() {
        return stockRepository.findAll();
    }



    @Override
    public Void deleteStock(Long id) {
        List<Product> products= productRepository.findAll();
        List<Product> productsOfStock=new ArrayList<>();
        for (Product product:products
             ) {
            System.out.println(product.getId());
            if(product.getStock().getId()==id) {
                product.setStateOfProduct(StockState.DESTROYED);
                productRepository.save(product);
                productsOfStock.add(product);


            }
        }
        Stock stock = stockRepository.findById(id).get();
        stock.setDeleteStock(Boolean.TRUE);
        stockRepository.save(stock);
        return null;
    }

    @Override
    public Integer numberOfProductInStock(Stock stock) {
        List<Product> productList= productRepository.findAll();
        productList=productList.stream().filter(product-> product.getStock().getId()== stock.getId()).toList();

        return productList.size();
    }

}
