package com.example.product.entity;

import lombok.*;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "location_id",nullable = false)
    private Location location;
    @ManyToOne
    @JoinColumn(name = "type_id",nullable = false)
    private Type type;
    @Column(name = "delete_stock")
    private Boolean deleteStock = Boolean.FALSE;
}
