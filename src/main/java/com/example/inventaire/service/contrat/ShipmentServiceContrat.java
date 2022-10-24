package com.example.inventaire.service.contrat;

import com.example.inventaire.entity.*;

import java.util.List;

public interface ShipmentServiceContrat {

    SampleLine ShipSample(SampleLine sampleLine, Location location, DfStatus dfStatus);
    Shipment getShipment(Long id);
    List<Shipment> getShipments();
    SampleLine returnSampleShipment(Long id);



}
