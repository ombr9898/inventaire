package com.example.inventaire.service.implementation;

import com.example.inventaire.entity.Sample;
import com.example.inventaire.entity.SampleLine;
import com.example.inventaire.repository.SampleLineRepository;
import com.example.inventaire.repository.SampleRepository;
import com.example.inventaire.service.contrat.SampleServiceContrat;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SampleService implements SampleServiceContrat {
    SampleRepository sampleRepository;
    SampleLineRepository sampleLineRepository;

    public SampleService(SampleRepository sampleRepository, SampleLineRepository sampleLineRepository) {
        this.sampleRepository = sampleRepository;
        this.sampleLineRepository = sampleLineRepository;
    }

    @Override
    public Sample addSample(Sample sample) {
        return sampleRepository.save(sample);
    }

    @Override
    public Sample updateSample(Long id, Sample sample) {
        sample.setId(id);
        sampleRepository.save(sample);
        return sample;
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
        sampleRepository.deleteById(id);
        return null;
    }

}
