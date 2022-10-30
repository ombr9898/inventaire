package com.example.shipement.controller;

import com.example.inventaire.entity.Stock;
import com.example.inventaire.service.implementation.StockService;

import java.util.List;
@RestController
public class StockController {
    StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;

    }
    @GetMapping(value="/stocks")
    public List<Stock> getStocks() {return stockService.getStocks();}

    @GetMapping(value="/stocks/{id}")
    public Stock getStock(@PathVariable("id") Long id) {return stockService.getStock(id);}

    @PostMapping(value = "/addstock")
    public Stock addStock(@RequestBody Stock stock) {return stockService.addStock(stock);}
    @DeleteMapping("/stock/{id}")
    public  String deleteStock(@PathVariable Long id){
        stockService.deleteStock(id);
    return "Stock Deleted";}
    @GetMapping(value = "/stock/numofproduct/{stock}")
    public Integer numberOfProductInStock(@PathVariable("stock") Stock stock) {
        return stockService.numberOfProductInStock(stock);
    }
}
