package com.example.inventaire.service.contrat;

import com.example.inventaire.entity.Box;
import com.example.inventaire.entity.Sample;
import com.example.inventaire.entity.SampleLine;

import java.util.List;
import java.util.Optional;

public interface SampleServiceContrat {
    Sample addSample(Sample sample);
    Sample getSample(Long id);
    List<Sample> getSamples();
    Void deleteSample(Long id);
    Integer numberOfSampleLineInSample(Sample sample);




}
