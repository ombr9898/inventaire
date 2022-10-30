package com.example.action.service.implementation;

import com.example.inventaire.entity.InventoryProduct;
import com.example.inventaire.repository.InventoryProductRepository;
import com.example.inventaire.service.contrat.InventoryProductServiceContrat;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InventoryProductService implements InventoryProductServiceContrat {


    InventoryProductRepository inventoryProductRepository;

    public InventoryProductService(InventoryProductRepository inventoryProductRepository){
        this.inventoryProductRepository = inventoryProductRepository;
    }
    @Override
    public InventoryProduct addSInventoryProduct(InventoryProduct inventoryProduct) {
        return inventoryProductRepository.save(inventoryProduct);
    }

    @Override
    public InventoryProduct updateInventoryProduct(Long id, InventoryProduct inventoryProduct) {
        inventoryProduct.setId(id);
        inventoryProductRepository.save(inventoryProduct);
        return inventoryProduct;
    }

    @Override
    public InventoryProduct getInventoryProduct(Long id) {
        return inventoryProductRepository.findById(id).get();
    }

    @Override
    public List<InventoryProduct> getInventoryProduct() {
        return inventoryProductRepository.findAll();
    }

    @Override
    public Void deleteInventoryProduct(Long id) {
        inventoryProductRepository.deleteById(id);
        return null;
    }
}
