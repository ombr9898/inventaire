package com.example.inventaire.service.implementation;

import com.example.inventaire.entity.Action;
import com.example.inventaire.entity.EnumOfProject.SampleState;
import com.example.inventaire.entity.EnumOfProject.TypeOfAction;
import com.example.inventaire.entity.Sample;
import com.example.inventaire.entity.SampleLine;
import com.example.inventaire.repository.ActionRepository;
import com.example.inventaire.repository.SampleLineRepository;
import com.example.inventaire.repository.SampleRepository;
import com.example.inventaire.service.contrat.SampleServiceContrat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SampleService implements SampleServiceContrat {
    SampleRepository sampleRepository;
    SampleLineRepository sampleLineRepository;
    ActionRepository actionRepository;


    public SampleService(SampleRepository sampleRepository, SampleLineRepository sampleLineRepository, ActionRepository actionRepository) {
        this.sampleRepository = sampleRepository;
        this.sampleLineRepository = sampleLineRepository;
        this.actionRepository = actionRepository;
    }

    @Override
    public Sample addSample(Sample sample) {
        return sampleRepository.save(sample);
    }



    @Override
    public Sample getSample(Long id) {
        return sampleRepository.findById(id).get();
    }

    @Override
    public List<Sample> getSamples() {
        return sampleRepository.findAll();
    }



    @Override
    public Void deleteSample(Long id) {
        List<SampleLine> samplelines= sampleLineRepository.findAll();
        List<SampleLine> samplelinesOfSample=new ArrayList<>();
        for (SampleLine sampleline:samplelines
             ) {
            System.out.println(sampleline.getId());
            if(sampleline.getSample().getId()==id) {
                sampleline.setStateOfSampleLine(SampleState.DESTROYED);
                sampleLineRepository.save(sampleline);
                samplelinesOfSample.add(sampleline);


            }
        }
        Action action=new Action();
        action.setListOfSampleLine(samplelinesOfSample);
        action.setTypeOfAction(TypeOfAction.TAKED);
        actionRepository.save(action);
        Sample sample=sampleRepository.findById(id).get();
        sample.setDeleteSample(Boolean.TRUE);
        sampleRepository.save(sample);
        return null;
    }

    @Override
    public Integer numberOfSampleLineInSample(Sample sample) {
        List<SampleLine> samplelines= sampleLineRepository.findAll();
        samplelines=samplelines.stream().filter(sampleLine -> sampleLine.getSample().getId()==sample.getId()).toList();

        return samplelines.size();
    }

}
