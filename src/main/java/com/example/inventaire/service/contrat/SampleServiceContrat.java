package com.example.inventaire.service.contrat;

import com.example.inventaire.entity.Sample;

import java.util.List;

public interface SampleServiceContrat {
    Sample addSample(Sample sample);
    Sample getSample(Long id);
    List<Sample> getSamples();
    Void deleteSample(Long id);
    Integer numberOfSampleLineInSample(Sample sample);




}
