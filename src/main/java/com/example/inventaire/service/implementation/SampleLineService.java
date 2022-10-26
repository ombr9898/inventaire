package com.example.inventaire.service.implementation;

import com.example.inventaire.entity.Action;
import com.example.inventaire.entity.EnumOfProject.LocationSample;
import com.example.inventaire.entity.EnumOfProject.SampleState;
import com.example.inventaire.entity.EnumOfProject.TypeOfAction;
import com.example.inventaire.entity.Sample;
import com.example.inventaire.entity.SampleLine;
import com.example.inventaire.repository.ActionRepository;
import com.example.inventaire.repository.SampleLineRepository;
import com.example.inventaire.service.contrat.SampleLineServiceContrat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SampleLineService implements SampleLineServiceContrat {
    SampleLineRepository sampleLineRepository;
    ActionRepository actionRepository;

    public SampleLineService(SampleLineRepository sampleLineRepository) {
        this.sampleLineRepository = sampleLineRepository;
    }

    @Override
    public SampleLine addSampleLine(SampleLine sampleLine) {
        Action action=new Action();
        List<SampleLine> sampleLineList=new ArrayList<>();
        sampleLineList.add(sampleLine);
        action.setListOfSampleLine(sampleLineList);
        action.setTypeOfAction(TypeOfAction.CREATED);
        actionRepository.save(action);
        return sampleLineRepository.save(sampleLine);
    }

    @Override
    public List<SampleLine> getSampleLineOfSample(Sample sample) {
        List<SampleLine> samplelines= sampleLineRepository.findAll();
        samplelines=samplelines.stream().filter(sampleLine -> sampleLine.getSample().getId()==sample.getId()).toList();


        return samplelines;
    }

    @Override
    public SampleLine updateSampleLine(Long id, SampleLine sampleLine) {
        Action action=new Action();
        List<SampleLine> sampleLineList=new ArrayList<>();
        sampleLineList.add(sampleLine);
        action.setListOfSampleLine(sampleLineList);
        action.setTypeOfAction(TypeOfAction.MODIFIED);
        actionRepository.save(action);
        sampleLine.setId(id);
        return sampleLineRepository.save(sampleLine) ;
    }

    @Override
    public SampleLine getSampleLine(Long id) {
        return sampleLineRepository.findById(id).get();
    }

    @Override
    public List<SampleLine> getAllSampleLines() {
        return sampleLineRepository.findAll();
    }

    @Override
    public List<SampleLine> takeSampleLines(List<SampleLine> sampleLineList) {
        Action action=new Action();
        action.setListOfSampleLine(sampleLineList);
        action.setTypeOfAction(TypeOfAction.TAKED);
        actionRepository.save(action);
        for (SampleLine sampleLine:
             sampleLineList) {
            sampleLine.setComment("Taked by User");
            sampleLine.setLocationOfSample(LocationSample.OUT_OF_THE_BOX);
            sampleLineRepository.save(sampleLine);
        }
        return sampleLineList;
    }

    @Override
    public List<SampleLine> returnSampleLines(List<SampleLine> sampleLineList) {
        Action action=new Action();
        action.setListOfSampleLine(sampleLineList);
        action.setTypeOfAction(TypeOfAction.RETURNED);
        actionRepository.save(action);
        for (SampleLine sampleLine:
                sampleLineList) {
            sampleLine.setComment("Returned by User");
            sampleLine.setLocationOfSample(LocationSample.IN_THE_BOX);
            sampleLineRepository.save(sampleLine);

        }
        return sampleLineList;
    }


    @Override
    public Void deleteSampleLine(Long id) {
        Action action=new Action();
        List<SampleLine> sampleLineList=new ArrayList<>();
        sampleLineList.add(sampleLineRepository.findById(id).get());
        action.setListOfSampleLine(sampleLineList);
        action.setTypeOfAction(TypeOfAction.DELETED);
        actionRepository.save(action);
        sampleLineRepository.findById(id).get().setStateOfSampleLine(SampleState.DESTROYED);

        return null;
    }
}
