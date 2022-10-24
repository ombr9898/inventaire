package com.example.inventaire;

import com.example.inventaire.entity.*;
import com.example.inventaire.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class InventaireApplication implements CommandLineRunner {

    BoxRepository boxRepository;
    SampleRepository sampleRepository;
    SampleLineRepository sampleLineRepository;
    ProductRepository productRepository;
    TypeRepository typeRepository;
    ShipementRepository shipementRepository;
    InventoryRepository inventoryRepository;
    InventorySampleRepository inventorySampleRepository;

    public InventaireApplication(BoxRepository boxRepository, SampleRepository sampleRepository, SampleLineRepository sampleLineRepository, ProductRepository productRepository, TypeRepository typeRepository, ShipementRepository shipementRepository, InventoryRepository inventoryRepository, InventorySampleRepository inventorySampleRepository) {
        this.boxRepository = boxRepository;
        this.sampleRepository = sampleRepository;
        this.sampleLineRepository = sampleLineRepository;
        this.productRepository = productRepository;
        this.typeRepository = typeRepository;
        this.shipementRepository = shipementRepository;
        this.inventoryRepository = inventoryRepository;
        this.inventorySampleRepository = inventorySampleRepository;
    }

    public static void main(String[] args) {

        SpringApplication.run(InventaireApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Box box1 = new Box();
        box1.setComment("Add by Ramo");
        box1.setLocation(Location.BIG_SAFE);
        box1.setState(State.OPEN);
        Box box2 = new Box();
        box2.setComment("Add by Abdo");
        box2.setLocation(Location.SMALL_SAFE);
        box2.setState(State.OPEN);
        boxRepository.save(box1);
        boxRepository.save(box2);
        Type type1= new Type();
        type1.setFormFactor("DIL");
        Type type2= new Type();
        type2.setFormFactor("CQFP100");
        typeRepository.save(type1);
        typeRepository.save(type2);
        Product product1= new Product();
        product1.setNameOfProduct("K480");
        Product product2= new Product();
        product2.setNameOfProduct("33HTPM");
        productRepository.save(product1);
        productRepository.save(product2);
        Sample sample1= new Sample();
        sample1.setType(type1);
        sample1.setProduct(product1);
        sample1.setBox(box1);
        sample1.setLocationOfSample("In the box");
        sample1.setStateOfSample(SampleState.OK);
        Sample sample2= new Sample();
        sample2.setType(type2);
        sample2.setProduct(product2);
        sample2.setBox(box2);
        sample2.setLocationOfSample("In the box");
        sample2.setStateOfSample(SampleState.OK);
        sampleRepository.save(sample1);
        sampleRepository.save(sample2);
        List<SampleLine> sampleLineList =new ArrayList<>();
        for(int i=0;i<10;i++){
            SampleLine sampleLine=new SampleLine();
            sampleLine.setSample(sample1);
            sampleLineList.add(sampleLine);
            sampleLine.setSample(sample2);
            sampleLineList.add(sampleLine);

        }
        Inventory inventory=new Inventory();
        List<InventorySample> inventorySampleList =new ArrayList<>();
        for (SampleLine sampleLine:sampleLineList) {
            sampleLineRepository.save(sampleLine);
            InventorySample inventorySample=new InventorySample();
            inventorySample.setInventory(inventory);
            inventorySample.setSampleLine(sampleLine);
            inventorySampleList.add(inventorySample);
        }
        for (InventorySample inventorySample:inventorySampleList) {
            inventorySampleRepository.save(inventorySample);
        }









    }
}
