package com.example.inventaire.service.implementation;

import com.example.inventaire.entity.Location;
import com.example.inventaire.entity.Sample;
import com.example.inventaire.entity.SampleLine;
import com.example.inventaire.repository.LocationRepository;
import com.example.inventaire.repository.SampleLineRepository;
import com.example.inventaire.repository.SampleRepository;
import com.example.inventaire.service.contrat.LocationServiceContrat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LocationService implements LocationServiceContrat {
    LocationRepository locationRepository;
    SampleLineRepository sampleLineRepository;
    SampleRepository sampleRepository;

    public LocationService(LocationRepository locationRepository, SampleLineRepository sampleLineRepository, SampleRepository sampleRepository) {
        this.locationRepository = locationRepository;
        this.sampleLineRepository = sampleLineRepository;
        this.sampleRepository = sampleRepository;
    }

    @Override
    public Location addLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location updateLocation(Long id, Location location) {
        location.setId(id);
        locationRepository.save(location);
        return location;
    }

    @Override
    public Location getLocation(Long id) {
        return locationRepository.findById(id).get() ;
    }

    @Override
    public List<Location> getLocationes() {
        return locationRepository.findAll();
    }

    @Override
    public Void deleteLocation(Long id) {
        locationRepository.deleteById(id);
        return null;
    }

    @Override
    public Integer numberOfSampleLineInLocation(Location location) {
        List <Sample> samples= sampleRepository.findAll();
        samples=samples.stream().filter(sample -> sample.getLocation().getId()== location.getId()).toList();
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
