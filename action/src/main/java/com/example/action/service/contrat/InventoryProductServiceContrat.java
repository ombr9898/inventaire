package com.example.action.service.contrat;

import com.example.inventaire.entity.InventoryProduct;

import java.util.List;

public interface InventoryProductServiceContrat {

    InventoryProduct addSInventoryProduct(InventoryProduct inventoryProduct);
    InventoryProduct updateInventoryProduct(Long id, InventoryProduct inventoryProduct);
    InventoryProduct getInventoryProduct(Long id);
    List<InventoryProduct> getInventoryProduct();
    Void deleteInventoryProduct(Long id);


}
