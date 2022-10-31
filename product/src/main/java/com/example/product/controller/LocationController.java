package com.example.product.controller;

import com.example.product.entity.Location;
import com.example.product.entity.Product;
import com.example.product.service.implementation.LocationService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class LocationController {
    final LocationService LocationService;

    public LocationController(LocationService LocationService) {
        this.LocationService = LocationService;
    }

    @GetMapping(value = "/location")
    public List<Location> getLocation() {
        return LocationService.getLocation();
    }
    @GetMapping(value = "/location/{id}")
    public Optional<Location> getLocation(@PathVariable("id") Long id) {
        return LocationService.getLocation(id);
    }

    @PostMapping(value = "/location")
    public Location createLocation(@Valid @RequestBody Location location){
        return LocationService.addLocation(location);
    }
    @PutMapping(value= "/location")
    public Location updateLocation(@Valid @RequestBody Long id, Location location){
        return LocationService.updateLocation(id, location);
    }
    @DeleteMapping(value = "/locationDelete/{id}")
    public  String deleteLocation(@PathVariable Long id){
        LocationService.deleteLocation(id);
        return "Location Deleted";
    }


}
