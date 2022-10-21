package com.example.inventaire.entity;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

public class Shipement {
    @Id
    @GeneratedValue
    private Long id;
}
