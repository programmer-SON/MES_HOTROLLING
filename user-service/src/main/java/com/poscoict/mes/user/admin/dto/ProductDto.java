package com.poscoict.mes.user.admin.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDto implements Serializable {

    private String productId;
    private Double thickness;
    private Double width;
    private Double length;
}
