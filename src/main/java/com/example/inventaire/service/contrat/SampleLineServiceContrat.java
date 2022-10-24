package com.example.inventaire.service.contrat;

import com.example.inventaire.entity.Sample;
import com.example.inventaire.entity.SampleLine;

import java.util.List;

public interface SampleLineServiceContrat {
    SampleLine addSampleLine(SampleLine sampleLine);
    List<SampleLine> getSampleLineOfSample(Sample sample);
    SampleLine updateSampleLine(Long id,SampleLine sampleLine);
    SampleLine getSampleLine(Long id);
    List<SampleLine> getAllSampleLines();
    List<SampleLine> takeSampleLines(List<SampleLine> sampleLineList);
    List<SampleLine> returnSampleLines(List<SampleLine> sampleLineList);
    Void deleteSampleLine(Long id);
}
