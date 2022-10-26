package com.example.inventaire.entity;

import com.example.inventaire.entity.EnumOfProject.LocationSample;
import com.example.inventaire.entity.EnumOfProject.SampleState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import javax.validation.constraints.NotBlank;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Node("SampleLine")
public class SampleLine {
    @Id
    @GeneratedValue
    private Long id;
    @LastModifiedDate
    private Date dateEntered ;
    @NotBlank(message = "Sample state is required")
    private SampleState stateOfSampleLine=SampleState.OK;
    @Relationship(type = "SAMPLELINE_OF", direction = Relationship.Direction.OUTGOING)
    @NotBlank(message = "Sample is required")
    private Sample sample;
    private String comment;
    @NotBlank(message = "Location is required")
    private LocationSample locationOfSample=LocationSample.IN_THE_BOX ;
}
