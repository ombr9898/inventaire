package com.example.inventaire.service.implementation;

import com.example.inventaire.entity.Box;
import com.example.inventaire.entity.Sample;
import com.example.inventaire.entity.SampleLine;
import com.example.inventaire.repository.BoxRepository;
import com.example.inventaire.repository.SampleLineRepository;
import com.example.inventaire.repository.SampleRepository;
import com.example.inventaire.service.contrat.BoxServiceContrat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BoxService implements BoxServiceContrat {
    BoxRepository boxRepository;
    SampleLineRepository sampleLineRepository;
    SampleRepository sampleRepository;

    public BoxService(BoxRepository boxRepository, SampleLineRepository sampleLineRepository, SampleRepository sampleRepository) {
        this.boxRepository = boxRepository;
        this.sampleLineRepository = sampleLineRepository;
        this.sampleRepository = sampleRepository;
    }

    @Override
    public Box addBox(Box box) {
        return boxRepository.save(box);
    }

    @Override
    public Box updateBox(Long id, Box box) {
        box.setId(id);
        boxRepository.save(box);
        return  box;
    }

    @Override
    public Box getBox(Long id) {
        return boxRepository.findById(id).get() ;
    }

    @Override
    public List<Box> getBoxes() {
        return boxRepository.findAll();
    }

    @Override
    public Void deleteBox(Long id) {
        boxRepository.deleteById(id);
        return null;
    }

    @Override
    public Integer numberOfSampleLineInBox(Box box) {
        List <Sample> samples= sampleRepository.findAll();
        samples=samples.stream().filter(sample -> sample.getBox().getId()==box.getId()).toList();
        List<SampleLine> samplelinesSample= sampleLineRepository.findAll();
        List samplelines=new ArrayList();
        for (Sample sample:samples
             ) {
            List<SampleLine> sampleline=samplelinesSample.stream().filter(sampleLine -> sampleLine.getSample().getId()==sample.getId()).toList();
            for (int i=0;i<sampleline.size();i++)
            {
                samplelines.add(sampleline.get(i));
            }
        }
        return samplelines.size();
    }

}
