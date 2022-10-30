package com.example.action.service.implementation;

import com.example.inventaire.entity.Inventory;
import com.example.inventaire.entity.InventoryProduct;
import com.example.inventaire.entity.Product;
import com.example.inventaire.repository.InventoryProductRepository;
import com.example.inventaire.repository.InventoryRepository;
import com.example.inventaire.repository.ProductRepository;
import com.example.inventaire.service.contrat.InventoryServiceContrat;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InventoryService implements InventoryServiceContrat {
    InventoryRepository inventoryRepository;
    InventoryProductRepository inventoryProductRepository;
    ProductRepository productRepository;

    public InventoryService(InventoryRepository inventoryRepository, InventoryProductRepository inventoryProductRepository, ProductRepository productRepository) {
        this.inventoryRepository = inventoryRepository;
        this.inventoryProductRepository = inventoryProductRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Inventory addSInventory() {
        Inventory inventory=new Inventory();
        inventoryRepository.save(inventory);

        for (Product product: productRepository.findAll()
             ) {
            InventoryProduct inventoryProduct =new InventoryProduct();
            inventoryProduct.setInventory(inventory);
            inventoryProduct.setProduct(product);
            inventoryProductRepository.save(inventoryProduct);
        }

        return inventory ;
    }

    @Override
    public Inventory updateInventory(Long id, Inventory inventory) {
        inventory.setId(id);
        inventoryRepository.save(inventory);
        return inventory;
    }

    @Override
    public Inventory getInventory(Long id) {
        return inventoryRepository.findById(id).get();
    }

    @Override
    public List<Inventory> getInventories() {
        return inventoryRepository.findAll();
    }

    @Override
    public Void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
        return null;
    }
}
