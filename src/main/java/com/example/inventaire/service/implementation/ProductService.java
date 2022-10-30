package com.example.inventaire.service.implementation;

import com.example.inventaire.entity.Action;
import com.example.inventaire.entity.EnumOfProject.LocationStock;
import com.example.inventaire.entity.EnumOfProject.StockState;
import com.example.inventaire.entity.EnumOfProject.TypeOfAction;
import com.example.inventaire.entity.Product;
import com.example.inventaire.entity.Stock;
import com.example.inventaire.repository.ActionRepository;
import com.example.inventaire.repository.ProductRepository;
import com.example.inventaire.service.contrat.ProductServiceContrat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService implements ProductServiceContrat {
    ProductRepository productRepository;
    ActionRepository actionRepository;


    public ProductService(ProductRepository productRepository, ActionRepository actionRepository) {
        this.productRepository = productRepository;
        this.actionRepository = actionRepository;
    }

    @Override
    public Product addProduct(Product product) {
        Action action=new Action();
        List<Product> productList =new ArrayList<>();
        productList.add(product);
        action.setListOfProduct(productList);
        action.setTypeOfAction(TypeOfAction.CREATED);
        actionRepository.save(action);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProductOfStock(Stock stock) {
        List<Product> products= productRepository.findAll();
        products=products.stream().filter(productLine ->productLine.getStock().getId()== stock.getId()).toList();


        return products;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Action action=new Action();
        List<Product> productList =new ArrayList<>();
        productList.add(product);
        action.setListOfProduct(productList);
        action.setTypeOfAction(TypeOfAction.MODIFIED);
        actionRepository.save(action);
        product.setId(id);
        return productRepository.save(product) ;
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> takeProducts(List<Product> productList) {
        Action action=new Action();
        action.setListOfProduct(productList);
        action.setTypeOfAction(TypeOfAction.TAKED);
        actionRepository.save(action);
        for (Product product :
                productList) {
            product.setComment("Taked by User");
            product.setLocationOfStock(LocationStock.OUT_OF_THE_LOCATION);
            productRepository.save(product);
        }
        return productList;
    }

    @Override
    public List<Product> returnProducts(List<Product> productList) {
        Action action=new Action();
        action.setListOfProduct(productList);
        action.setTypeOfAction(TypeOfAction.RETURNED);
        actionRepository.save(action);
        for (Product product :
                productList) {
            product.setComment("Returned by User");
            product.setLocationOfStock(LocationStock.IN_THE_LOCATION);
            productRepository.save(product);

        }
        return productList;
    }


    @Override
    public Void deleteProduct(Long id) {
        Action action=new Action();
        List<Product> productList =new ArrayList<>();
        productList.add(productRepository.findById(id).get());
        action.setListOfProduct(productList);
        action.setTypeOfAction(TypeOfAction.DELETED);
        actionRepository.save(action);
        Product product = productRepository.findById(id).get();
        product.setStateOfProduct(StockState.DESTROYED);
        productRepository.save(product);
        return null;
    }
}
