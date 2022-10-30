package com.example.shipement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Node("Destination")
public class Destination {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String nameOfDesination;
    private boolean isInSt = Boolean.FALSE;
}
