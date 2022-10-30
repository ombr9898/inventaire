package com.example.action.controller;

import com.example.inventaire.entity.EnumOfProject.Location;
import com.example.inventaire.entity.Product;
import com.example.inventaire.entity.Shipment;
import com.example.inventaire.service.implementation.ShipmentService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ShipementController {
    ShipmentService shipmentService;
    public ShipementController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }
    @GetMapping(value = "/shipments")
    public List<Shipment> getShipmentsCont(){
        return shipmentService.getShipments();
    }

    @GetMapping(value = "/shipments/{id}")
    public Shipment getShipmentCont(@RequestParam("id") Long id){
        return shipmentService.getShipment(id);
    }



    @PostMapping(value = "/shipstock/")
    public Product ShipStockcont(@Valid @RequestBody Shipment shipment) {

        return shipmentService.ShipStock(shipment.getProduct(),Location.BIG_SAFE,shipment.getDfStatus());
    }

    @PostMapping(value = "/returnshipement/")
    public Product ReturnStockShippedCont(@RequestBody Long id) {
        return shipmentService.returnStockShipment(id);
    }

}
