package com.example.inventaire.repository;

import com.example.inventaire.entity.Box;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface BoxRepository extends Neo4jRepository<Box,Long> {
}
