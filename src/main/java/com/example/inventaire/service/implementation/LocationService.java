package com.example.inventaire.service.implementation;

import com.example.inventaire.entity.Location;
import com.example.inventaire.entity.Product;
import com.example.inventaire.entity.Sample;
import com.example.inventaire.repository.LocationRepository;
import com.example.inventaire.repository.ProductRepository;
import com.example.inventaire.repository.SampleRepository;
import com.example.inventaire.service.contrat.LocationServiceContrat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LocationService implements LocationServiceContrat {
    LocationRepository locationRepository;
    ProductRepository productRepository;
    SampleRepository sampleRepository;

    public LocationService(LocationRepository locationRepository, ProductRepository productRepository, SampleRepository sampleRepository) {
        this.locationRepository = locationRepository;
        this.productRepository = productRepository;
        this.sampleRepository = sampleRepository;
    }

    @Override
    public Location addLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location updateLocation(Long id, Location location) {
        location.setId(id);
        locationRepository.save(location);
        return location;
    }

    @Override
    public Location getLocation(Long id) {
        return locationRepository.findById(id).get() ;
    }

    @Override
    public List<Location> getLocationes() {
        return locationRepository.findAll();
    }

    @Override
    public Void deleteLocation(Long id) {
        locationRepository.deleteById(id);
        return null;
    }

    @Override
    public Integer numberOfProductInLocation(Location location) {
        List <Sample> samples= sampleRepository.findAll();
        samples=samples.stream().filter(sample -> sample.getLocation().getId()== location.getId()).toList();
        List<Product> productList= productRepository.findAll();
        List productListByLocation=new ArrayList();
        
        for (Sample sample:samples
             ) {
            List<Product> product=productList.stream().filter(productLine ->productLine.getSample().getId()==sample.getId()).toList();
            for (int i=0;i<product.size();i++)
            {
                productListByLocation.add(product.get(i));
            }
        }
        return productListByLocation.size();
    }

}
