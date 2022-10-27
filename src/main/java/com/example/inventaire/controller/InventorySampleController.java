package com.example.inventaire.controller;

import com.example.inventaire.entity.InventorySample;
import com.example.inventaire.service.implementation.InventorySampleService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class InventorySampleController {
    InventorySampleService inventorySampleService;
    public InventorySampleController(InventorySampleService inventorySampleService){this.inventorySampleService=inventorySampleService;}
    @GetMapping(value = "/inventoriesSample")
    public List<InventorySample> getInventoriesSample() {return inventorySampleService.getInventoriesSample();}
    @GetMapping(value = "/inventorySample")
    public  InventorySample getInventorySample(@PathVariable("id") Long id){return inventorySampleService.getInventorySample(id);}
    @PostMapping(value = "/inventorySample")
    public  InventorySample addSInventorySample(@Valid @RequestBody InventorySample inventorySample){return inventorySampleService.addSInventorySample(inventorySample);}
    @PutMapping(value = "/inventorySample")
    public InventorySample updateInventorySample(@Valid @RequestBody Long id, InventorySample inventorySample){return inventorySampleService.updateInventorySample(id, inventorySample);}
    @DeleteMapping(value = "/inventorySampleDelete")
    public String deleteInventorySample(@PathVariable("id") Long id){inventorySampleService.deleteInventorySample(id);
        return "InventorySample Deleted";
    }


}
