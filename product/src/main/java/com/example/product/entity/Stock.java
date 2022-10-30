package com.example.product.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Node("Stock")
public class Stock {
    @Id
    @GeneratedValue
    private Long id;
    @Relationship(type = "STOCK_IN", direction = Relationship.Direction.OUTGOING)
    @NotNull
    private Location location;
    @Relationship(type = "STOCK_DIFFERENT", direction = Relationship.Direction.OUTGOING)
    @NotNull
    private Type type;
    @NotNull
    @Relationship(type = "STOCK_AS", direction = Relationship.Direction.OUTGOING)
    private Product product;
    private Boolean deleteStock = Boolean.FALSE;
}
