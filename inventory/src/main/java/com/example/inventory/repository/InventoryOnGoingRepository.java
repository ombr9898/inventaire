package com.example.inventory.repository;

import com.example.inventaire.entity.InventoryOnGoing;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryOnGoingRepository extends Neo4jRepository<InventoryOnGoing,Long> {
}
