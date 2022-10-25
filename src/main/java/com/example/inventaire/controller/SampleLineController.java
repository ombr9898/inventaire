package com.example.inventaire.controller;

import com.example.inventaire.entity.Sample;
import com.example.inventaire.entity.SampleLine;
import com.example.inventaire.service.implementation.SampleLineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SampleLineController {
    SampleLineService sampleLineService;

    public SampleLineController(SampleLineService sampleLineService) {
        this.sampleLineService = sampleLineService;
    }
    @GetMapping(value = "/samplelinebysample/{sample}")
    public List<SampleLine> getSampleLineOfSample(@PathVariable("sample") Sample sample){return sampleLineService.getSampleLineOfSample(sample);}
    @GetMapping(value = "/sampleline/{id}")
    public SampleLine getSampleLine(@PathVariable("id") Long id){return sampleLineService.getSampleLine(id);}
    @GetMapping(value = "/sampleline")
    public List<SampleLine> getAllSampleLine(){return sampleLineService.getAllSampleLines();}
    @PostMapping(value = "/sampleline")
    public  SampleLine addSampleLine(@RequestBody SampleLine sampleLine){return sampleLineService.addSampleLine(sampleLine);}

    @PutMapping(value = "/sampleline")
    public  SampleLine updateSampleLine(@RequestBody Long id,SampleLine sampleLine){return sampleLineService.updateSampleLine(id,sampleLine);}

    @PostMapping(value="/takesample")
            public List<SampleLine> takeSampleLines(List<SampleLine> sampleLineList){return sampleLineService.takeSampleLines(sampleLineList);}
    @PostMapping(value = "returnsample")
    public List<SampleLine> returnSampleLines(List<SampleLine> sampleLineList){return sampleLineService.returnSampleLines(sampleLineList);}

    @DeleteMapping(value = "/sampleline/{id}")
    String deleteSampleLine(@PathVariable("id") Long id){sampleLineService.deleteSampleLine(id); return "SampleLine deleted" ;}

}
