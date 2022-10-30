package com.example.shipement.entity;

import com.example.inventaire.entity.EnumOfProject.LocationStock;
import com.example.inventaire.entity.EnumOfProject.StockState;
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
    private StockState stateOfProduct=StockState.OK;
    @Relationship(type = "PRODUCT_OF", direction = Relationship.Direction.OUTGOING)
    @NotNull
    private Stock stock;
    private String comment;
    @NotNull
    private LocationStock locationOfStock=LocationStock.IN_THE_LOCATION ;
}
