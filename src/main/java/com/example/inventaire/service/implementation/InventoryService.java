package com.example.inventaire.service.implementation;

import com.example.inventaire.entity.Inventory;
import com.example.inventaire.repository.InventoryRepository;
import com.example.inventaire.service.contrat.InventoryServiceContrat;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InventoryService implements InventoryServiceContrat {
    InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Inventory addSInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
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
