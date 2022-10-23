package com.example.inventaire.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OLF {
    @Id
    @GeneratedValue
    private Long id;

    }
