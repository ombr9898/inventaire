package com.example.product.dto;

import com.example.product.entity.EnumOfProject.LocationStock;
import com.example.product.entity.EnumOfProject.StockState;
import lombok.Data;

import java.util.Date;

@Data
public class ProductDto {
    private Long id;
    private Date dateEntered;
    private StockState stateOfProduct = StockState.OK;
    private Integer stock;
    private String comment;
    private LocationStock locationOfStock = LocationStock.IN_THE_LOCATION;
}
