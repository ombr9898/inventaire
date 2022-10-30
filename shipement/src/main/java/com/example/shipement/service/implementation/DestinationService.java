package com.example.shipement.service.implementation;

import com.example.inventaire.entity.Destination;
import com.example.inventaire.repository.DestinationRepository;
import com.example.inventaire.service.contrat.DestinationServiceContrat;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DestinationService implements DestinationServiceContrat {
    DestinationRepository destinationRepository;
    public DestinationService(DestinationRepository destinationRepository){
        this.destinationRepository=destinationRepository;
    }
    @Override
    public Destination addDestination(Destination destination) {
        return destinationRepository.save(destination);
    }

    @Override
    public Destination updateDestination(Long id, Destination destination) {
        destination.setId(id);
        destinationRepository.save(destination);
        return destination;
    }

    @Override
    public Destination getDestination(Long id) {
        return destinationRepository.findById(id).get();


    }

    @Override
    public List<Destination> getDestinations() {
        return destinationRepository.findAll();
    }

    @Override
    public Void deleteDestination(Long id) {
        destinationRepository.deleteById(id);

        return null;
    }
}
