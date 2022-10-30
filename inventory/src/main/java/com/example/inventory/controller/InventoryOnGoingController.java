package com.example.inventory.controller;


import com.example.inventaire.service.implementation.InventoryOnGoingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryOnGoingController {

    public InventoryOnGoingController(InventoryOnGoingService inventoryOnGoingService) {
        this.inventoryOnGoingService = inventoryOnGoingService;
    }

    InventoryOnGoingService inventoryOnGoingService;
        @GetMapping(value = "/invotoryin")
        public String inventoryInGoing(){
            return inventoryOnGoingService.inventoryInGoing().toString();
        }
        @GetMapping(value = "/invotoryout")
        public String inventoryOutGoing(){
            return inventoryOnGoingService.inventoryOutGoing().toString();
        }
    }

