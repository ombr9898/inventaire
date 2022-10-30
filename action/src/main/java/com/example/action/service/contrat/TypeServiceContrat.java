package com.example.action.service.contrat;

import com.example.inventaire.entity.Type;

import java.util.List;

public interface TypeServiceContrat {
    Type addType(Type type);
    Type updateType(Long id,Type type);
    Type getType(Long id);
    List<Type> getTypes();
    Void deleteType(Long id);



}
