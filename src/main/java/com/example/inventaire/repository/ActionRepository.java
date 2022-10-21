package com.example.inventaire.repository;

import com.example.inventaire.entity.Action;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ActionRepository extends Neo4jRepository<Action,Long> {
}
