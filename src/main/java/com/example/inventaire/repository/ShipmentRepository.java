package com.example.inventaire.repository;

import com.example.inventaire.entity.Shipment;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends Neo4jRepository<Shipment,Long> {
}
