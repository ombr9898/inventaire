package com.example.inventaire.service.contrat;

import com.example.inventaire.entity.Location;

import java.util.List;

public interface LocationServiceContrat {
    Location addLocation(Location location);
    Location updateLocation(Long id, Location location);
    Location getLocation(Long id);
    List<Location> getLocationes();
    Void deleteLocation(Long id);

    Integer numberOfProductInLocation(Location location);
}
