package com.example.product.service.contrat;


import com.example.product.entity.Stock;

import java.util.List;
import java.util.Optional;

public interface StockServiceContrat {
    Stock addStock(Stock stock);

    Stock updateStock(Stock stock);

    Optional<Stock> getStock(Long id);

    List<Stock> getStocks();

    void deleteStock(Long id);



}
