package com.example.inventaire.controller;

import com.example.inventaire.entity.Sample;
import com.example.inventaire.entity.SampleLine;
import com.example.inventaire.service.implementation.SampleLineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SampleLineController {
    SampleLineService sampleLineService;

    public SampleLineController(SampleLineService sampleLineService) {
        this.sampleLineService = sampleLineService;
    }
    @GetMapping(value = "/sampleline/{sample}")
    public List<SampleLine> getSampleLineOfSample(@PathVariable("sample") Sample sample){return sampleLineService.getSampleLineOfSample(sample);}
}
