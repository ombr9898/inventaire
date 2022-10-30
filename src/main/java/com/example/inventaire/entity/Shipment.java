package com.example.inventaire.entity;

import com.example.inventaire.entity.EnumOfProject.DfStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
@Node("Shipment")
public class Shipment {
    @Id
    @GeneratedValue
    private Long id;
    private DfStatus dfStatus;
    private Date sentDate;
    private String Comment;
    @Relationship(type="SHIPMENT_TO", direction = Relationship.Direction.OUTGOING)
    private Destination destination;
    @Relationship(type = "SHIPMENT_OF", direction = Relationship.Direction.OUTGOING)
    @NotNull
    private Product product;

}
