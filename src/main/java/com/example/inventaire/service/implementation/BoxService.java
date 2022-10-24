package com.example.inventaire.service.implementation;

import com.example.inventaire.entity.Box;
import com.example.inventaire.repository.BoxRepository;
import com.example.inventaire.service.contrat.BoxServiceContrat;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BoxService implements BoxServiceContrat {
    BoxRepository boxRepository;

    public BoxService(BoxRepository boxRepository) {
        this.boxRepository = boxRepository;
    }

    @Override
    public Box addBox(Box box) {
        return boxRepository.save(box);
    }

    @Override
    public Box updateBox(Long id, Box box) {
        box.setId(id);
        boxRepository.save(box);
        return  box;
    }

    @Override
    public Optional<Box> getBox(Long id) {
        return boxRepository.findById(id) ;
    }

    @Override
    public List<Box> getBoxes() {
        return boxRepository.findAll();
    }

    @Override
    public Void deleteBox(Long id) {
        boxRepository.deleteById(id);

        return null;
    }

}
