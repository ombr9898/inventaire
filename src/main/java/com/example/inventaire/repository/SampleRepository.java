package com.example.inventaire.repository;

import com.example.inventaire.entity.Sample;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface SampleRepository extends Neo4jRepository<Sample,Long> {
}
