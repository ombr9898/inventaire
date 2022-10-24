package com.example.inventaire.service.implementation;

import com.example.inventaire.entity.*;
import com.example.inventaire.repository.SampleLineRepository;
import com.example.inventaire.repository.ShipmentRepository;
import com.example.inventaire.service.contrat.ShipmentServiceContrat;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShipmentService implements ShipmentServiceContrat {
    ShipmentRepository shipmentRepository;
    SampleLineRepository sampleLineRepository;

    @Override
    public SampleLine ShipSample(SampleLine sampleLine, Location location, DfStatus dfStatus) {
        Shipment shipment = new Shipment();
        shipment.setSampleLine(sampleLine);
        shipment.setDfStatus(dfStatus);
        shipmentRepository.save(shipment);
        sampleLine.setComment("Shipped by user");
        sampleLine.setLocationOfSample(LocationSample.OUTSIDE);
        sampleLineRepository.save(sampleLine);

        return sampleLine;
    }

    @Override
    public Shipment getShipment(Long id) {
        return shipmentRepository.findById(id).get();
    }

    @Override
    public List<Shipment> getShipments() {
        return shipmentRepository.findAll();
    }

    @Override
    public SampleLine returnSampleShipment(Long id) {
        Shipment shipment=shipmentRepository.findById(id).get();
        SampleLine sampleLine=shipment.getSampleLine();
        sampleLine.setComment("Returned by User");
        sampleLine.setLocationOfSample(LocationSample.IN_THE_BOX);
        sampleLineRepository.save(sampleLine);
        shipmentRepository.deleteById(id);
        return sampleLine;
    }
}
