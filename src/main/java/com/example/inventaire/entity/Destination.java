package com.example.inventaire.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Node("Destination")
public class Destination {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "The name of the destination is required")
    private String nameOfDesination;
    private boolean isInSt = Boolean.FALSE;
}
