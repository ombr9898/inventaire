package com.example.inventaire;

import com.example.inventaire.entity.*;
import com.example.inventaire.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class InventaireApplication implements CommandLineRunner {

    BoxRepository boxRepository;
    SampleRepository sampleRepository;
    SampleLineRepository sampleLineRepository;
    ProductRepository productRepository;
    TypeRepository typeRepository;
    ShipementRepository shipementRepository;

    public InventaireApplication(BoxRepository boxRepository, SampleRepository sampleRepository, SampleLineRepository sampleLineRepository, ProductRepository productRepository, TypeRepository typeRepository, ShipementRepository shipementRepository) {
        this.boxRepository = boxRepository;
        this.sampleRepository = sampleRepository;
        this.sampleLineRepository = sampleLineRepository;
        this.productRepository = productRepository;
        this.typeRepository = typeRepository;
        this.shipementRepository = shipementRepository;
    }

    public static void main(String[] args) {

        SpringApplication.run(InventaireApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Type type=new Type();
        typeRepository.save(type);
        Product product=new Product();
        productRepository.save(product);
        Box box=new Box();
        boxRepository.save(box);
        Sample sample=new Sample();
        sample.setBox(box);
        sample.setType(type);
        sample.setProduct(product);

        sampleRepository.save(sample);
        SampleLine sampleLine=new SampleLine();
        sampleLine.setSample(sample);
        SampleLine sampleLine2=new SampleLine();
        sampleLine2.setSample(sample);
        SampleLine sampleLine3=new SampleLine();
        sampleLine3.setSample(sample);
        sampleLineRepository.save(sampleLine);
        sampleLineRepository.save(sampleLine2);
        sampleLineRepository.save(sampleLine3);
        Shipment shipment=new Shipment();
        shipment.setSampleLine(sampleLine);
        shipementRepository.save(shipment);


    }
}
