package com.example.inventaire.service.implementation;

import com.example.inventaire.entity.*;
import com.example.inventaire.entity.EnumOfProject.DfStatus;
import com.example.inventaire.entity.EnumOfProject.Location;
import com.example.inventaire.entity.EnumOfProject.LocationSample;
import com.example.inventaire.entity.EnumOfProject.TypeOfAction;
import com.example.inventaire.repository.ActionRepository;
import com.example.inventaire.repository.SampleLineRepository;
import com.example.inventaire.repository.ShipmentRepository;
import com.example.inventaire.service.contrat.ShipmentServiceContrat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ShipmentService implements ShipmentServiceContrat {
    ShipmentRepository shipmentRepository;
    SampleLineRepository sampleLineRepository;
    ActionRepository actionRepository;

    public ShipmentService(ShipmentRepository shipmentRepository, SampleLineRepository sampleLineRepository, ActionRepository actionRepository) {
        this.shipmentRepository = shipmentRepository;
        this.sampleLineRepository = sampleLineRepository;
        this.actionRepository = actionRepository;
    }

    @Override
    public SampleLine ShipSample(SampleLine sampleLine, Location location, DfStatus dfStatus) {
        Action action=new Action();
        List<SampleLine> sampleLineList=new ArrayList<>();
        sampleLineList.add(sampleLine);
        action.setListOfSampleLine(sampleLineList);
        action.setTypeOfAction(TypeOfAction.MODIFIED);
        actionRepository.save(action);
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
        sampleLine.setLocationOfSample(LocationSample.IN_THE_LOCATION);
        sampleLineRepository.save(sampleLine);
        shipmentRepository.deleteById(id);
        return sampleLine;
    }
}
