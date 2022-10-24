package com.example.inventaire.repository;

import com.example.inventaire.entity.Destination;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends Neo4jRepository<Destination,Long> {
}
