package com.example.inventaire.repository;

import com.example.inventaire.entity.InventorySample;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventorySampleRepository extends Neo4jRepository<InventorySample,Long> {
}
