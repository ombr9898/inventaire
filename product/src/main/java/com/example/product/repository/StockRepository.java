package com.example.product.repository;

import com.example.product.entity.Stock;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends Neo4jRepository<Stock,Long> {
}
