package com.example.shipement.entity;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("InventoryOnGoing")
public class InventoryOnGoing {
    @Id@GeneratedValue
    private Long id;
    private   Boolean isInventoryGoing=Boolean.FALSE ;
    private InventoryOnGoing()
    {}

    /** Instance unique pré-initialisée */
    private static InventoryOnGoing INSTANCE = new InventoryOnGoing();

    /** Point d'accès pour l'instance unique du singleton */
    public static Boolean getInstanceBool()
    {   return INSTANCE.isInventoryGoing;
    }
    public static InventoryOnGoing getInstance()
    {   return INSTANCE;
    }
    public static InventoryOnGoing setInstanceBool(Boolean bool)

    {   INSTANCE.isInventoryGoing=bool;
        return INSTANCE;
    }



}
