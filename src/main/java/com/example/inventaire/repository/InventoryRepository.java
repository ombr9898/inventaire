package com.example.inventaire.repository;

import com.example.inventaire.entity.Inventory;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface InventoryRepository extends Neo4jRepository<Inventory,Long> {
}
