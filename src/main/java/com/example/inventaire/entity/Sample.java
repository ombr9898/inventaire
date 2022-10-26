package com.example.inventaire.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Node("Sample")
public class Sample {
    @Id
    @GeneratedValue
    private Long id;
    @Relationship(type = "SAMPLE_IN", direction = Relationship.Direction.OUTGOING)
    @NotBlank(message = "Box is required")
    private Box box;
    @Relationship(type = "SAMPLE_DIFFERENT", direction = Relationship.Direction.OUTGOING)
    @NotBlank(message = "Type is required")
    private Type type;
    @NotBlank(message = "Type is required")
    @Relationship(type = "SAMPLE_AS", direction = Relationship.Direction.OUTGOING)
    private Product product;
    private Boolean deleteSample=Boolean.FALSE;
}
