package com.example.inventaire.service.contrat;

import com.example.inventaire.entity.*;
import com.example.inventaire.entity.EnumOfProject.DfStatus;
import com.example.inventaire.entity.EnumOfProject.Location;

import java.util.List;

public interface ShipmentServiceContrat {

    Product ShipSample(Product product, Location location, DfStatus dfStatus);
    Shipment getShipment(Long id);
    List<Shipment> getShipments();
    Product returnSampleShipment(Long id);



}
