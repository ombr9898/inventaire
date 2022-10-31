package com.example.product.service.implementation;

import com.example.product.entity.Location;
import com.example.product.entity.Product;
import com.example.product.entity.Stock;
import com.example.product.repository.LocationRepository;
import com.example.product.service.contrat.LocationServiceContrat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LocationService implements LocationServiceContrat {
    LocationRepository locationRepository;
    ProductService productService;
    StockService stockService;

    public LocationService(LocationRepository locationRepository, ProductService productService, StockService stockService) {
        this.locationRepository = locationRepository;
        this.productService = productService;
        this.stockService = stockService;
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
    public Optional<Location> getLocation(Long id) {
        return locationRepository.findById(id);
    }

    @Override
    public List<Location> getLocation() {
        return locationRepository.findAll();
    }

    @Override
    public Void deleteLocation(Long id) {
        locationRepository.deleteById(id);
        return null;
    }



}
