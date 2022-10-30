package com.example.shipement.service.contrat;

import com.example.inventaire.entity.Stock;

import java.util.List;

public interface StockServiceContrat {
    Stock addStock(Stock stock);
    Stock getStock(Long id);
    List<Stock> getStocks();
    Void deleteStock(Long id);
    Integer numberOfProductInStock(Stock stock);




}
