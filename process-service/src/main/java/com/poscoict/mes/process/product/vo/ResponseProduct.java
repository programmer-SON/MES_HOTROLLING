package com.poscoict.mes.process.product.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseProduct {

    private String productId;
    private Integer thickness;
    private Integer width;
    private Integer length;
    private Integer stock;
}
