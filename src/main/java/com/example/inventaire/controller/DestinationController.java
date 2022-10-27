package com.example.inventaire.controller;

import com.example.inventaire.entity.Destination;
import com.example.inventaire.service.implementation.DestinationService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DestinationController {
    DestinationService destinationService;

    public DestinationController(DestinationService destinationService ){this.destinationService=destinationService;}

    @GetMapping(value="/destinations")
    public List<Destination> getDestinations() {return destinationService.getDestinations();}

    @GetMapping(value="/destination/{id}")

    public Destination getDestination(@PathVariable("id") Long id){return destinationService.getDestination(id);}

    @PostMapping(value="/destination")

    public Destination addDestination(@Valid @RequestBody Destination destination){return destinationService.addDestination(destination);}

    @PutMapping(value="/destination")

    public Destination updateDestination(@Valid @RequestBody Long id, Destination destination){return destinationService.updateDestination(id,destination);}

    @DeleteMapping(value="/destiantionDelete/{id}")

    public String deleteDestination(@PathVariable Long id){
        destinationService.deleteDestination(id);
        return "This destination has been deleted";
    }
}
