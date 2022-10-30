package com.example.inventory.controller;

import com.example.inventaire.entity.Type;
import com.example.inventaire.service.implementation.TypeService;

import javax.validation.Valid;
import java.util.List;
@RestController
public class TypeController {
    TypeService typeService;

    public TypeController(TypeService typeService){this.typeService= typeService;}
    @GetMapping(value = "/types")
    public List<Type> getTypes() {return typeService.getTypes();}
    @GetMapping(value = "/types/{id}")
    public Type getType( @PathVariable("id") Long id) {
        return typeService.getType(id);
    }
    @PostMapping(value = "/type")
    public Type createType(@Valid @RequestBody Type type){return typeService.addType(type);}
    @PutMapping(value= "/type")
    public  Type updateType(@Valid @RequestBody Long id, Type type){return typeService.updateType(id, type);}
    @DeleteMapping(value = "/typeDelete/{id}")
    public  String deleteType(@PathVariable Long id){
        typeService.deleteType(id);
        return "Type Deleted";
    }
}
