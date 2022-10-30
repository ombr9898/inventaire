package com.example.product.service.contrat;



import com.example.product.entity.Location;

import java.util.List;
import java.util.Optional;

public interface LocationServiceContrat {
    Location addLocation(Location location);
    Location updateLocation(Long id, Location location);
    Optional<Location> getLocation(Long id);
    List<Location> getLocation();
    Void deleteLocation(Long id);

    Integer numberOfProductInLocation(Location location);
}
