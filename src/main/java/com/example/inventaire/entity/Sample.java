package com.example.inventaire.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Date;
import java.util.TimeZone;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Node("Sample")
public class Sample {
    @Id
    @GeneratedValue
    private Long id;
    private String nameOfSample ;
    private String stateOfSample ;
    private String locationOfSample ;
    private String Comment ;
    private Date dateEntered ;
    private int quantity ;
    @Relationship(type ="SAMPLE_IN", direction = Relationship.Direction.INCOMING)
    private Box box;
    @Relationship(type ="SAMPLE_DIFFERENT", direction = Relationship.Direction.INCOMING)
    private Type type;
    @Relationship(type="SAMPLE_AS", direction = Relationship.Direction.INCOMING)
    private Product product;
}
