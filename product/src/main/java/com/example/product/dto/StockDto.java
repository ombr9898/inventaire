package com.example.product.dto;

import com.example.product.entity.Location;
import com.example.product.entity.Type;
import lombok.Data;

@Data
public class StockDto {
    private Long id;
    private Integer location;
    private Integer type;
    private Boolean deleteStock = Boolean.FALSE;


}

