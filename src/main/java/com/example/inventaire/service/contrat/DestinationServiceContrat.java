package com.example.inventaire.service.contrat;

import com.example.inventaire.entity.Destination;

import java.util.List;

public interface DestinationServiceContrat {
    Destination addDestination(Destination destination);
    Destination updateDestination(Long id,Destination destination);
    Destination getDestination(Long id);
    List<Destination> getDestinations();
    Void deleteDestination(Long id);

}
