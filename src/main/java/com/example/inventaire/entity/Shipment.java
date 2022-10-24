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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Node("Shipment")
public class Shipment {
    @Id
    @GeneratedValue
    private Long id;
    private String dfStatus;
    private Date sentDate;
    private String Comment;
    private int quantity;
    private String OLFStatus ;
    @Relationship(type = "SHIPMENT_OF", direction = Relationship.Direction.INCOMING)
    private Sample sample;

}
