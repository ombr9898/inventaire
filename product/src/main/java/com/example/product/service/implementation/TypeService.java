package com.example.product.service.implementation;


import com.example.product.entity.Type;
import com.example.product.repository.TypeRepository;
import com.example.product.service.contrat.TypeServiceContrat;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService implements TypeServiceContrat {
    TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public Type addType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public Type updateType(Integer id, Type type) {
        type.setId(id);
        typeRepository.save(type);
        return type;
    }

    @Override
    public Optional<Type> getType(Integer id) {
        return typeRepository.findById(id);
    }

    @Override
    public List<Type> getTypes() {

        return typeRepository.findAll();
    }

    @Override
    public Void deleteType(Integer id) {
        typeRepository.deleteById(id);
        return null;
    }
}
