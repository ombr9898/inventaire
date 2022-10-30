package com.example.product.controller;

import com.example.product.dto.StockDto;
import com.example.product.entity.Stock;
import com.example.product.service.implementation.LocationService;
import com.example.product.service.implementation.StockService;
import com.example.product.service.implementation.TypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StockController {
    @Autowired
    StockService stockService;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    TypeService typeService;
    @Autowired
    LocationService locationService;
    private Stock convertToEntity(StockDto stockDto) {
        Stock stock = modelMapper.map(stockDto, Stock.class);
        stock.setType(typeService.getType(stockDto.getType()).get());
        stock.setLocation(locationService.getLocation(Long.valueOf(stockDto.getLocation())).get());
        return stock;
    }

    @GetMapping(value="/stock")
    public List<Stock> getStock() {return stockService.getStocks();}

    @GetMapping(value="/stock/{id}")
    public Optional<Stock> getStock(@PathVariable("id") Long id) {return stockService.getStock(id);}

    @PostMapping(value = "/stock")
    public Stock addStock(@RequestBody StockDto stockDto) {
        Stock stock=convertToEntity(stockDto);
        return stockService.addStock(stock);
    }
    @DeleteMapping("/stock/{id}")
    public  String deleteStock(@PathVariable Long id){
        stockService.deleteStock(id);
    return "Stock Deleted";}
    @GetMapping(value = "/stock/numofproduct/{id}")
    public Integer numberOfProductInStock(@PathVariable("id") Long id) {
        return stockService.numberOfProductInStock(id);
    }
}
