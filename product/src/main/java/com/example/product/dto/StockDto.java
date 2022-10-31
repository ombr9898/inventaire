package com.example.product.dto;

import lombok.Data;

@Data
public class StockDto {
    private Long id;
    private Integer location;
    private Integer type;
    private Boolean deleteStock = Boolean.FALSE;


}

