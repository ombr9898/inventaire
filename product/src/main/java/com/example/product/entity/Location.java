package com.example.product.entity;

import com.example.product.entity.EnumOfProject.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "comment")
    private String comment;
    @Column(name = "state",nullable = false)
    private State state;
    @Column(name = "date_c")
    private Date dateOfCreation;
    @Column(name = "date_u")
    private Date dateOfUpdated;

}
