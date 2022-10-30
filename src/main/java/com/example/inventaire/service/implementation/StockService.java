package com.example.inventaire.service.implementation;

import com.example.inventaire.entity.Action;
import com.example.inventaire.entity.EnumOfProject.StockState;
import com.example.inventaire.entity.EnumOfProject.TypeOfAction;
import com.example.inventaire.entity.Stock;
import com.example.inventaire.entity.Product;
import com.example.inventaire.repository.ActionRepository;
import com.example.inventaire.repository.ProductRepository;
import com.example.inventaire.repository.StockRepository;
import com.example.inventaire.service.contrat.StockServiceContrat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService implements StockServiceContrat {
    StockRepository stockRepository;
    ProductRepository productRepository;
    ActionRepository actionRepository;


    public StockService(StockRepository stockRepository, ProductRepository productRepository, ActionRepository actionRepository) {
        this.stockRepository = stockRepository;
        this.productRepository = productRepository;
        this.actionRepository = actionRepository;
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
        Action action=new Action();
        action.setListOfProduct(productsOfStock);
        action.setTypeOfAction(TypeOfAction.TAKED);
        actionRepository.save(action);
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
