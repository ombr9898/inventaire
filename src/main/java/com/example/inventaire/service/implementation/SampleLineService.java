package com.example.inventaire.service.implementation;

import com.example.inventaire.entity.LocationSample;
import com.example.inventaire.entity.Sample;
import com.example.inventaire.entity.SampleLine;
import com.example.inventaire.repository.SampleLineRepository;
import com.example.inventaire.service.contrat.SampleLineServiceContrat;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SampleLineService implements SampleLineServiceContrat {
    SampleLineRepository sampleLineRepository;

    public SampleLineService(SampleLineRepository sampleLineRepository) {
        this.sampleLineRepository = sampleLineRepository;
    }

    @Override
    public SampleLine addSampleLine(SampleLine sampleLine) {
        return sampleLineRepository.save(sampleLine);
    }

    @Override
    public List<SampleLine> getSampleLineOfSample(Sample sample) {

        return sampleLineRepository.findBySample(sample);
    }

    @Override
    public SampleLine updateSampleLine(Long id, SampleLine sampleLine) {
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
        sampleLineRepository.deleteById(id);
        return null;
    }
}
