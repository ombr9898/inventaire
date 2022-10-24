package com.example.inventaire.controller;

import com.example.inventaire.entity.Box;
import com.example.inventaire.service.implementation.BoxService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BoxController {
    BoxService boxService;

    public BoxController(BoxService boxService) {
        this.boxService = boxService;
    }

    @GetMapping(value = "/boxes")
    public List<Box> getBoxes() {
        return boxService.getBoxes();
    }
    @GetMapping(value = "/boxes/{id}")
    public Box getBox( @PathVariable("id") Long id) {
        return boxService.getBox(id);
    }
    @PostMapping(value = "/box")
    public Box createBox(@RequestBody Box box){return boxService.addBox(box);}
    @PutMapping(value= "/box")
    public  Box updateBox(@RequestBody Long id, Box box){return boxService.updateBox(id, box);}
    @DeleteMapping(value = "/boxDelete")
    public  String deleteBox(@RequestBody Long id){
        boxService.deleteBox(id);
        return "Box Deleted";
    }
}
