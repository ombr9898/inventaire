package com.example.inventaire.controller;

import com.example.inventaire.entity.Box;
import com.example.inventaire.entity.Inventory;
import com.example.inventaire.service.implementation.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class InventoryController {
    InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {this.inventoryService= inventoryService;}

    @GetMapping(value = "/inventories")
    public List<Inventory> getInventories() {
        return inventoryService.getInventories();
    }

    @GetMapping(value="/inventory/{id}")
    public Inventory getInventory(@PathVariable("id") Long id) {return inventoryService.getInventory(id);}

    @PostMapping(value = "/inventory")
    public  Inventory createInventory(){return inventoryService.addSInventory();}

    @PutMapping(value ="/inventory")

    public Inventory updateInventory(@RequestBody Long id, Inventory inventory){return inventoryService.updateInventory(id,inventory);}

    @DeleteMapping(value ="/inventoryDelete/{id}")

    public String deleteInventory(@PathVariable("id") Long id){inventoryService.deleteInventory(id);
        return "Inventory Deleted";
    }

}
