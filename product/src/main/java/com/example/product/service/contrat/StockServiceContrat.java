package com.example.product.service.contrat;


import com.example.product.entity.Stock;

import java.util.List;

public interface StockServiceContrat {
    Stock addStock(Stock stock);
    Stock getStock(Long id);
    List<Stock> getStocks();
    Void deleteStock(Long id);
    Integer numberOfProductInStock(Stock stock);




}
