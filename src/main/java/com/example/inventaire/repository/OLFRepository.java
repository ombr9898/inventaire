package com.example.inventaire.repository;

import com.example.inventaire.entity.OLF;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface OLFRepository extends Neo4jRepository<OLF,Long> {
}
