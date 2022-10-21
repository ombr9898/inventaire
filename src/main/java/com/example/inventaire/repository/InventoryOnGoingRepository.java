package com.example.inventaire.repository;

import com.example.inventaire.entity.InventoryOnGoing;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface InventoryOnGoingRepository extends Neo4jRepository<InventoryOnGoing,Long> {
}
