package com.example.inventory.repository;

import com.example.inventaire.entity.Product;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends Neo4jRepository<Product,Long> {

}
