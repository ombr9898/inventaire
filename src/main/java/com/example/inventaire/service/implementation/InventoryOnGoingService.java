package com.example.inventaire.service.implementation;
import com.example.inventaire.entity.InventoryOnGoing;
import com.example.inventaire.repository.InventoryOnGoingRepository;
import com.example.inventaire.service.contrat.InventoryOnGoingServiceContrat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryOnGoingService implements InventoryOnGoingServiceContrat {
    public InventoryOnGoingService(InventoryOnGoingRepository inventoryOnGoingRepository) {
        this.inventoryOnGoingRepository = inventoryOnGoingRepository;
    }


    InventoryOnGoingRepository inventoryOnGoingRepository;


    @Override
    public Boolean inventoryInGoing() {
        System.out.println(1);
        InventoryOnGoing.setInstanceBool(Boolean.TRUE);
        inventoryOnGoingRepository.save(InventoryOnGoing.getInstance());
        return InventoryOnGoing.getInstanceBool();
    }

    @Override
    public Boolean inventoryOutGoing() {
        InventoryOnGoing.setInstanceBool(Boolean.FALSE);
        inventoryOnGoingRepository.save(InventoryOnGoing.getInstance());
        return InventoryOnGoing.getInstanceBool();
    }
}
