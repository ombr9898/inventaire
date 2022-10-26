package com.example.inventaire.entity;

import com.example.inventaire.entity.EnumOfProject.Location;
import com.example.inventaire.entity.EnumOfProject.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Node("Box")
public class Box {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "Location is required")
    private Location location;
    private String comment;
    @NotBlank(message = "State is required")
    private State state=State.SEALED;
    private Date dateOfCreation;
    private Date dateOfUpdated;

}
