package com.example.inventaire.controller;

import com.example.inventaire.entity.Sample;
import com.example.inventaire.service.implementation.SampleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class SampleController {
    SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;

    }
    @GetMapping(value="/samples")
    public List<Sample> getSamples() {return sampleService.getSamples();}

    @GetMapping(value="/samples/{id}")
    public Sample getSample(@PathVariable("id") Long id) {return sampleService.getSample(id);}

    @PostMapping(value = "/addsample")
    public Sample addSample(@RequestBody Sample sample) {return sampleService.addSample(sample);}

    @PutMapping(value= "/samples")
    public Sample updateSample(@RequestBody Long id, Sample sample) {return sampleService.updateSample(id,sample);}

}
