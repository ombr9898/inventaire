package com.example.inventaire.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Node("InventorySample")
public class InventorySample {
    @Id
    @GeneratedValue
    private Long id;
    private Inventory inventory;
    private SampleLine sampleLine;
    private InventoryCheck inventoryChecked1;
    private InventoryCheck inventoryChecked2;
    private String Comment;


}
