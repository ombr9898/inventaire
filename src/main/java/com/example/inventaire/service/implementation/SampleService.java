package com.example.inventaire.service.implementation;

import com.example.inventaire.entity.Action;
import com.example.inventaire.entity.EnumOfProject.SampleState;
import com.example.inventaire.entity.EnumOfProject.TypeOfAction;
import com.example.inventaire.entity.Sample;
import com.example.inventaire.entity.Product;
import com.example.inventaire.repository.ActionRepository;
import com.example.inventaire.repository.ProductRepository;
import com.example.inventaire.repository.SampleRepository;
import com.example.inventaire.service.contrat.SampleServiceContrat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SampleService implements SampleServiceContrat {
    SampleRepository sampleRepository;
    ProductRepository productRepository;
    ActionRepository actionRepository;


    public SampleService(SampleRepository sampleRepository, ProductRepository productRepository, ActionRepository actionRepository) {
        this.sampleRepository = sampleRepository;
        this.productRepository = productRepository;
        this.actionRepository = actionRepository;
    }

    @Override
    public Sample addSample(Sample sample) {
        return sampleRepository.save(sample);
    }



    @Override
    public Sample getSample(Long id) {
        return sampleRepository.findById(id).get();
    }

    @Override
    public List<Sample> getSamples() {
        return sampleRepository.findAll();
    }



    @Override
    public Void deleteSample(Long id) {
        List<Product> products= productRepository.findAll();
        List<Product> productsOfSample=new ArrayList<>();
        for (Product product:products
             ) {
            System.out.println(product.getId());
            if(product.getSample().getId()==id) {
                product.setStateOfProduct(SampleState.DESTROYED);
                productRepository.save(product);
                productsOfSample.add(product);


            }
        }
        Action action=new Action();
        action.setListOfProduct(productsOfSample);
        action.setTypeOfAction(TypeOfAction.TAKED);
        actionRepository.save(action);
        Sample sample=sampleRepository.findById(id).get();
        sample.setDeleteSample(Boolean.TRUE);
        sampleRepository.save(sample);
        return null;
    }

    @Override
    public Integer numberOfProductInSample(Sample sample) {
        List<Product> productList= productRepository.findAll();
        productList=productList.stream().filter(product-> product.getSample().getId()==sample.getId()).toList();

        return productList.size();
    }

}
