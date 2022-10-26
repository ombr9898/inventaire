package com.example.inventaire.service.contrat;

import com.example.inventaire.entity.Inventory;
import com.example.inventaire.entity.InventorySample;

import java.util.List;

public interface InventorySampleServiceContrat {

    InventorySample addSInventorySample(InventorySample inventorySample);
    InventorySample updateInventorySample(Long id,InventorySample inventorySample);
    InventorySample getInventorySample(Long id);
    List<InventorySample> getInventoriesSample();
    Void deleteInventorySample(Long id);


}
