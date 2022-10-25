package com.example.inventaire.controller;

import com.example.inventaire.entity.Product;
import com.example.inventaire.entity.Type;
import com.example.inventaire.service.implementation.ProductService;
import com.example.inventaire.service.implementation.TypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProductController {
    ProductService productService;
    public  ProductController( ProductService  productService){this.productService= productService;}
    @GetMapping(value = "/products")
    public List<Product> getProducts() {
        return  productService.getProducts();
    }
    @GetMapping(value = "/products/{id}")
    public  Product getProduct( @PathVariable("id") Long id) {
        return productService.getProduct(id);
    }
    @PostMapping(value = "/product")
    public  Product createProduct(@RequestBody  Product  product){return productService.addProduct(product);}
    @PutMapping(value= "/product")
    public   Product updateProduct(@RequestBody Long id,  Product product){return productService.updateProduct(id, product);}
    @DeleteMapping(value = "/productDelete/{id}")
    public  String deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
        return "Product Deleted";
    }

}
