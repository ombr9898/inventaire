package com.example.inventaire.entity;

import com.example.inventaire.entity.EnumOfProject.LocationSample;
import com.example.inventaire.entity.EnumOfProject.SampleState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import javax.validation.constraints.NotNull;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Node("Product")
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    @LastModifiedDate
    private Date dateEntered ;
    @NotNull
    private SampleState stateOfProduct=SampleState.OK;
    @Relationship(type = "PRODUCT_OF", direction = Relationship.Direction.OUTGOING)
    @NotNull
    private Sample sample;
    private String comment;
    @NotNull
    private LocationSample locationOfSample=LocationSample.IN_THE_LOCATION ;
}
