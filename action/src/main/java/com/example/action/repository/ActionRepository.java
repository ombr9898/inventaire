package com.example.action.repository;

import com.example.inventaire.entity.Action;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends Neo4jRepository<Action,Long> {
}
