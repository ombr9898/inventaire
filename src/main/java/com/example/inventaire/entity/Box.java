package com.example.inventaire.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Node("Box")
public class Box {
    @Id
    @GeneratedValue
    private Long id;
    private Location location;
    private String comment;
    private State state;
    private Date dateOfCreation;
    private Date dateOfUpdated;
    private int numberOfSample;

}
