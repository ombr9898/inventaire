package com.example.inventaire.entity;

import com.example.inventaire.entity.EnumOfProject.InventoryCheck;
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
@Node("InventorySample")
public class InventorySample {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "Inventory is required")

    private Inventory inventory;
    @NotBlank(message = "SampleLines is required")

    private SampleLine sampleLine;
    private InventoryCheck inventoryChecked1=InventoryCheck.NOT_LOCATED;
    private InventoryCheck inventoryChecked2=InventoryCheck.NOT_LOCATED;
    private String Comment;


}
