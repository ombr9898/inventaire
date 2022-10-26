package com.example.inventaire.service.implementation;

import com.example.inventaire.entity.InventorySample;
import com.example.inventaire.repository.InventorySampleRepository;
import com.example.inventaire.service.contrat.InventorySampleServiceContrat;
import com.example.inventaire.service.contrat.InventoryServiceContrat;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InventorySampleService implements InventorySampleServiceContrat {


    InventorySampleRepository inventorySampleRepository;

    public InventorySampleService(InventorySampleRepository inventorySampleRepository){
        this.inventorySampleRepository=inventorySampleRepository;
    }
    @Override
    public InventorySample addSInventorySample(InventorySample inventorySample) {
        return inventorySampleRepository.save(inventorySample);
    }

    @Override
    public InventorySample updateInventorySample(Long id, InventorySample inventorySample) {
        inventorySample.setId(id);
        inventorySampleRepository.save(inventorySample);
        return inventorySample;
    }

    @Override
    public InventorySample getInventorySample(Long id) {
        return inventorySampleRepository.findById(id).get();
    }

    @Override
    public List<InventorySample> getInventoriesSample() {
        return inventorySampleRepository.findAll();
    }

    @Override
    public Void deleteInventorySample(Long id) {
        inventorySampleRepository.deleteById(id);
        return null;
    }
}
