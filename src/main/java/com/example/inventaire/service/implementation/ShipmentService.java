package com.example.inventaire.service.implementation;

import com.example.inventaire.entity.*;
import com.example.inventaire.entity.EnumOfProject.DfStatus;
import com.example.inventaire.entity.EnumOfProject.Location;
import com.example.inventaire.entity.EnumOfProject.LocationSample;
import com.example.inventaire.entity.EnumOfProject.TypeOfAction;
import com.example.inventaire.repository.ActionRepository;
import com.example.inventaire.repository.ProductRepository;
import com.example.inventaire.repository.ShipmentRepository;
import com.example.inventaire.service.contrat.ShipmentServiceContrat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ShipmentService implements ShipmentServiceContrat {
    ShipmentRepository shipmentRepository;
    ProductRepository productRepository;
    ActionRepository actionRepository;

    public ShipmentService(ShipmentRepository shipmentRepository, ProductRepository productRepository, ActionRepository actionRepository) {
        this.shipmentRepository = shipmentRepository;
        this.productRepository = productRepository;
        this.actionRepository = actionRepository;
    }

    @Override
    public Product ShipSample(Product product, Location location, DfStatus dfStatus) {
        Action action=new Action();
        List<Product> productList =new ArrayList<>();
        productList.add(product);
        action.setListOfProduct(productList);
        action.setTypeOfAction(TypeOfAction.MODIFIED);
        actionRepository.save(action);
        Shipment shipment = new Shipment();
        shipment.setProduct(product);
        shipment.setDfStatus(dfStatus);
        shipmentRepository.save(shipment);
        product.setComment("Shipped by user");
        product.setLocationOfSample(LocationSample.OUTSIDE);
        productRepository.save(product);

        return product;
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
    public Product returnSampleShipment(Long id) {
        Shipment shipment=shipmentRepository.findById(id).get();
        Product product =shipment.getProduct();
        product.setComment("Returned by User");
        product.setLocationOfSample(LocationSample.IN_THE_LOCATION);
        productRepository.save(product);
        shipmentRepository.deleteById(id);
        return product;
    }
}
