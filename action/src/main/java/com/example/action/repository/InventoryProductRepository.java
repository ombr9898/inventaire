package com.example.action.repository;

import com.example.inventaire.entity.InventoryProduct;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryProductRepository extends Neo4jRepository<InventoryProduct,Long> {
}
