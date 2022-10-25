package com.example.inventaire.service.contrat;

import com.example.inventaire.entity.Box;

import java.util.List;
import java.util.Optional;

public interface BoxServiceContrat {
    Box addBox(Box box);
    Box updateBox(Long id,Box box);
    Box getBox(Long id);
    List<Box> getBoxes();
    Void deleteBox(Long id);

}
