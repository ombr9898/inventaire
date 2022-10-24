package com.example.inventaire.controller;

import com.example.inventaire.entity.DfStatus;
import com.example.inventaire.entity.Location;
import com.example.inventaire.entity.SampleLine;
import com.example.inventaire.entity.Shipment;
import com.example.inventaire.repository.ShipmentRepository;
import com.example.inventaire.service.implementation.ShipmentService;
import org.springframework.web.bind.annotation.*;

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



    @PostMapping(value = "/shipsample/")
    public SampleLine ShipSamplecont(@RequestBody SampleLine sampleLine, Location location, DfStatus dfStatus) {

        return shipmentService.ShipSample(sampleLine,location,dfStatus);
    }

    @PostMapping(value = "/returnshipement/")
    public SampleLine ReturnSampleShippedCont(@RequestBody Long id) {
        return shipmentService.returnSampleShipment(id);
    }

}
