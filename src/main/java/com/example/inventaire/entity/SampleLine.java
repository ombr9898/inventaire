package com.example.inventaire.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Node("SampleLine")
public class SampleLine {
    @Id
    @GeneratedValue
    private Long id;
    @LastModifiedDate
    private Date dateEntered ;
    @Relationship(type = "SAMPLELINE_OF", direction = Relationship.Direction.OUTGOING)
    private Sample sample;
    private String comment;
    private LocationSample locationOfSample ;
}
