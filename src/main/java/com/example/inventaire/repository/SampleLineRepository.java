package com.example.inventaire.repository;

import com.example.inventaire.entity.SampleLine;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleLineRepository  extends Neo4jRepository<SampleLine,Long> {
}
