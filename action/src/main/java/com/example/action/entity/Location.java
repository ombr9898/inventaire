package com.example.action.entity;

import com.example.inventaire.entity.EnumOfProject.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Node("Location")
public class Location {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private com.example.inventaire.entity.EnumOfProject.Location location;
    private String comment;
    @NotNull
    private State state=State.SEALED;
    private Date dateOfCreation;
    private Date dateOfUpdated;

}
