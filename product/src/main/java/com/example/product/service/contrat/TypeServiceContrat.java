package com.example.product.service.contrat;

import com.example.product.entity.Type;

import java.util.List;
import java.util.Optional;

public interface TypeServiceContrat {
    Type addType(Type type);
    Type updateType(Integer id,Type type);
    Optional<Type> getType(Integer id);
    List<Type> getTypes();
    Void deleteType(Integer id);



}
