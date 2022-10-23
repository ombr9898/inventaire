package com.example.inventaire.entity;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

import java.sql.Time;
import java.util.TimeZone;


public class Box {

    @Id
    @GeneratedValue
    private Long id;
    private String boxOfName;
    private String location;
    private String comment;
    private String state;
    private TimeZone dateOfCreation;
    private TimeZone dateOfUpdated;
    private int numberOfSample;


}
