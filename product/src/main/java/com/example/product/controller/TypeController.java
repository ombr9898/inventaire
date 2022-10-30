package com.example.product.controller;

import com.example.product.entity.Type;
import com.example.product.service.implementation.TypeService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class TypeController {
    TypeService typeService;

    public TypeController(TypeService typeService){this.typeService= typeService;}
    @GetMapping(value = "/types")
    public List<Type> getTypes() {return typeService.getTypes();}
    @GetMapping(value = "/types/{id}")
    public Optional<Type> getType(@PathVariable("id") Integer id) {
        return typeService.getType(id);
    }
    @PostMapping(value = "/type")
    public Type createType(@Valid @RequestBody Type type){return typeService.addType(type);}
    @PutMapping(value= "/type")
    public  Type updateType(@Valid @RequestBody Integer id, Type type){return typeService.updateType(id, type);}
    @DeleteMapping(value = "/typeDelete/{id}")
    public  String deleteType(@PathVariable Integer id){
        typeService.deleteType(id);
        return "Type Deleted";
    }
}
