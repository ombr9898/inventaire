package com.example.shipement.repository;

import com.example.inventaire.entity.Type;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends Neo4jRepository<Type,Long> {
}
