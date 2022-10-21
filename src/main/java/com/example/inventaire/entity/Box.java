package com.example.inventaire.entity;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

public class Box {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Box( String name) {
        this.name = name;
    }
}
