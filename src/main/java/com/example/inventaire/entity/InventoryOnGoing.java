package com.example.inventaire.entity;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

public class InventoryOnGoing {
    @Id
    @GeneratedValue
    private Long id;
}
