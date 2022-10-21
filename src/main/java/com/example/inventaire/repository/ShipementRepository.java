package com.example.inventaire.repository;

import com.example.inventaire.entity.Shipement;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ShipementRepository extends Neo4jRepository<Shipement,Long> {
}
