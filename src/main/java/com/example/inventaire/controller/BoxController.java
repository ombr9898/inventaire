package com.example.inventaire.controller;

import com.example.inventaire.entity.Box;
import com.example.inventaire.service.implementation.BoxService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

}
