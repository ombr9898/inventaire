package com.example.product.entity;

import com.example.product.entity.EnumOfProject.LocationStock;
import com.example.product.entity.EnumOfProject.StockState;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    @CreationTimestamp
    private Date dateEntered;
    @Column(name = "stock_state")
    private StockState stateOfProduct = StockState.OK;
    @ManyToOne
    @JoinColumn(name = "stock_id",nullable = false)
    private Stock stock;
    @Column(name = "comment")
    private String comment;
    @Column(name = "location_stock")
    private LocationStock locationOfStock = LocationStock.IN_THE_LOCATION;
}
