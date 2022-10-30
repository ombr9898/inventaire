package com.example.product.entity;

import com.example.product.entity.EnumOfProject.LocationStock;
import com.example.product.entity.EnumOfProject.StockState;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

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
    private Date dateEntered ;
    @NotNull
    @Column(name = "stock_state")
    private StockState stateOfProduct=StockState.OK;
    @ManyToOne
    @JoinColumn(name = "stock_id")
    @NotNull
    private Stock stock;
    @Column(name = "comment")
    private String comment;
    @NotNull
    @Column(name = "location_stock")
    private LocationStock locationOfStock=LocationStock.IN_THE_LOCATION ;
}
