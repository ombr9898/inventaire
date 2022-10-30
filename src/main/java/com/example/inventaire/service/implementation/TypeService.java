package com.example.inventaire.service.implementation;

import com.example.inventaire.entity.Type;
import com.example.inventaire.repository.TypeRepository;
import com.example.inventaire.service.contrat.TypeServiceContrat;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeService implements TypeServiceContrat {
    TypeRepository typeRepository;
    public TypeService(TypeRepository typeRepository){
        this.typeRepository = typeRepository;
    }
    @Override
    public Type addType(Type type) {


        return typeRepository.save(type);
    }

    @Override
    public Type updateType(Long id, Type type) {
        type.setId(id);
        typeRepository.save(type);
        return type;
    }

    @Override
    public Type getType(Long id) {
        return typeRepository.findById(id).get();
    }

    @Override
    public List<Type> getTypes() {

        return typeRepository.findAll();
    }

    @Override
    public Void deleteType(Long id) {
        typeRepository.deleteById(id);
        return null;
    }
}
