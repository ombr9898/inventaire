package com.example.product.controller;



import com.example.product.entity.Product;
import com.example.product.entity.Stock;
import com.example.product.service.implementation.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping(value = "/productbystock/{stock}")
    public List<Product> getProductOfStock(@PathVariable("stock") Stock stock){return productService.getProductOfStock(stock);}
    @GetMapping(value = "/product/{id}")
    public Product getProduct(@PathVariable("id") Long id){return productService.getProduct(id);}
    @GetMapping(value = "/product")
    public List<Product> getAllProduct(){return productService.getAllProducts();}
    @PostMapping(value = "/product")
    public Product addProduct(@Valid @RequestBody Product product){return productService.addProduct(product);}

    @PutMapping(value = "/product")
    public Product updateProduct(@Valid @RequestBody Long id, Product product){return productService.updateProduct(id, product);}

    @PostMapping(value="/takestock")
            public List<Product> takeProducts(@RequestBody List<Product> productList){return productService.takeProducts(productList);}
    @PostMapping(value = "returnstock")
    public List<Product> returnProducts(@RequestBody List<Product> productList){return productService.returnProducts(productList);}

    @DeleteMapping(value = "/product/{id}")
    String deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id); return "Product deleted" ;}

}
