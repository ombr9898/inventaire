package com.example.product.entity;

import com.example.product.entity.EnumOfProject.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
    @CreationTimestamp
    private Date dateOfCreation;
    @Column(name = "date_u")
    @UpdateTimestamp
    private Date dateOfUpdated;

}
