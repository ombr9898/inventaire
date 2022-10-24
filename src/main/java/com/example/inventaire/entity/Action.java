package com.example.inventaire.entity;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Node("Action")
public class Action {
    @Id
    @GeneratedValue
    private Long id;
    private String typeOfAction ;
    private int qauntity ;
    private Date dateOfAction;
    @Relationship(type="ACTION_OF", direction = Relationship.Direction.INCOMING)
    private List <Sample> listOfSample ;


}
