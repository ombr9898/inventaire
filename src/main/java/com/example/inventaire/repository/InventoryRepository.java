package com.example.inventaire.repository;

import com.example.inventaire.entity.Inventory;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends Neo4jRepository<Inventory,Long> {
}
