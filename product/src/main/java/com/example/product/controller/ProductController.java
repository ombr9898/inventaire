package com.example.product.controller;


import com.example.product.dto.ProductDto;
import com.example.product.entity.Product;
import com.example.product.entity.Stock;
import com.example.product.service.implementation.ProductService;
import com.example.product.service.implementation.StockService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    final
    ProductService productService;
    final
    StockService stockService;
    final
    ModelMapper modelMapper;

    public ProductController(ProductService productService, StockService stockService, ModelMapper modelMapper) {
        this.productService = productService;
        this.stockService = stockService;
        this.modelMapper = modelMapper;
    }


    private Product convertToEntity(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        product.setStock(stockService.getStock(Long.valueOf(productDto.getStock())).get());
        return product;
    }

    @GetMapping(value = "/productbystock/{stock}")
    public List<Product> getProductOfStock(@PathVariable("stock") Stock stock) {
        return productService.getProductOfStock(stock);
    }

    @GetMapping(value = "/product/{id}")
    public Optional<Product> getProduct(@PathVariable("id") Long id) {
        return productService.getProduct(id);
    }

    @GetMapping(value = "/product")
    public List<Product> getAllProduct() {
        return productService.getAllProducts();
    }

    @PostMapping(value = "/product")
    public Product addProduct(@Valid @RequestBody ProductDto productDto) {
        Product product = convertToEntity(productDto);
        return productService.addProduct(product);
    }

    @PutMapping(value = "/product")
    public Product updateProduct(@Valid @RequestBody Long id, Product product) {
        return productService.updateProduct(id, product);
    }

    @PostMapping(value = "/takestock")
    public List<Product> takeProducts(@RequestBody List<Product> productList) {
        return productService.takeProducts(productList);
    }

    @PostMapping(value = "returnstock")
    public List<Product> returnProducts(@RequestBody List<Product> productList) {
        return productService.returnProducts(productList);
    }

    @DeleteMapping(value = "/product/{id}")
    String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return "Product deleted";
    }

}
