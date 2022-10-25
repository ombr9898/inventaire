package com.example.inventaire.service.implementation;

import com.example.inventaire.entity.Type;
import com.example.inventaire.repository.ProductRepository;
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
        Type type1 = new Type();
        type1.setFormFactor("DIL");
        typeRepository.save(type1);
        return typeRepository.findAll();
    }

    @Override
    public Void deleteType(Long id) {
        typeRepository.deleteById(id);
        return null;
    }
}
