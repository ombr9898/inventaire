package com.example.action.controller;

import com.example.inventaire.entity.InventoryProduct;
import com.example.inventaire.service.implementation.InventoryProductService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class InventoryProductController {
    InventoryProductService inventoryProductService;
    public InventoryProductController(InventoryProductService inventoryProductService){this.inventoryProductService=inventoryProductService;}
    @GetMapping(value = "/inventoryProduct")
    public List<InventoryProduct> getInventoryProduct() {return inventoryProductService.getInventoryProduct();}
    @GetMapping(value = "/inventoryProduct/{id}")
    public InventoryProduct getInventoryProduct(@PathVariable("id") Long id){return inventoryProductService.getInventoryProduct(id);}
    @PostMapping(value = "/inventoryProduct")
    public InventoryProduct addSInventoryProduct(@Valid @RequestBody InventoryProduct inventoryProduct){return inventoryProductService.addSInventoryProduct(inventoryProduct);}
    @PutMapping(value = "/inventoryProduct")
    public InventoryProduct updateInventoryProduct(@Valid @RequestBody Long id, InventoryProduct inventoryProduct){return inventoryProductService.updateInventoryProduct(id, inventoryProduct);}
    @DeleteMapping(value = "/inventoryProductDelete")
    public String deleteInventoryProduct(@PathVariable("id") Long id){inventoryProductService.deleteInventoryProduct(id);
        return "InventoryProduct Deleted";
    }


}
