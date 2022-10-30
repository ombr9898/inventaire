package com.example.inventaire.entity;

import com.example.inventaire.entity.EnumOfProject.InventoryCheck;
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
@Node("InventoryProduct")
public class InventoryProduct {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Relationship(type = "INVENTORY_STOCK_WITH", direction = Relationship.Direction.OUTGOING)

    private Inventory inventory;
    @NotNull
    @Relationship(type = "INVENTORY_STOCK_OF", direction = Relationship.Direction.OUTGOING)
    private Product product;
    private InventoryCheck inventoryChecked1=InventoryCheck.NOT_LOCATED;
    private InventoryCheck inventoryChecked2=InventoryCheck.NOT_LOCATED;
    private String Comment;


}
