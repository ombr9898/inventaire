package com.example.inventaire.entity;

import com.example.inventaire.entity.EnumOfProject.TypeOfAction;
import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Node("Action")
public class Action {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "Type of action is required")
    private TypeOfAction typeOfAction ;
    private Date dateOfAction;
    @Relationship(type="ACTION_OF", direction = Relationship.Direction.INCOMING)
    @NotBlank(message = "SampleLines is required")
    private List <SampleLine> listOfSampleLine ;


}
