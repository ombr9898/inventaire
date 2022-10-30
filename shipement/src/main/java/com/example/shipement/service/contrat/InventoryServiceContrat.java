package com.example.shipement.service.contrat;

import com.example.inventaire.entity.Inventory;

import java.util.List;

public interface InventoryServiceContrat {


    Inventory addSInventory();
    Inventory updateInventory(Long id,Inventory inventory);
    Inventory getInventory(Long id);
    List<Inventory> getInventories();
    Void deleteInventory(Long id);
}
