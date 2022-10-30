package com.example.inventory.controller;

import com.example.inventaire.entity.Location;
import com.example.inventaire.service.implementation.LocationService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LocationController {
    LocationService LocationService;

    public LocationController(LocationService LocationService) {
        this.LocationService = LocationService;
    }

    @GetMapping(value = "/locationes")
    public List<Location> getLocationes() {
        return LocationService.getLocationes();
    }
    @GetMapping(value = "/locationes/{id}")
    public Location getLocation(@PathVariable("id") Long id) {
        return LocationService.getLocation(id);
    }
    @PostMapping(value = "/location")
    public Location createLocation(@Valid @RequestBody Location location){return LocationService.addLocation(location);}
    @PutMapping(value= "/location")
    public Location updateLocation(@Valid @RequestBody Long id, Location location){return LocationService.updateLocation(id, location);}
    @DeleteMapping(value = "/locationDelete/{id}")
    public  String deleteLocation(@PathVariable Long id){
        LocationService.deleteLocation(id);
        return "Location Deleted";
    }
    @GetMapping(value = "/location/numofproduct/{location}")
    public Integer numberOfProductInLocation(@PathVariable("location") Location location) {
        return LocationService.numberOfProductInLocation(location);
    }
}
