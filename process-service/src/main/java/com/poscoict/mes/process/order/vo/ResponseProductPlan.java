package com.poscoict.mes.process.order.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.poscoict.mes.process.company.vo.ResponseCompany;
import com.poscoict.mes.process.product.vo.ResponseProduct;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseProductPlan {
    List<ResponseCompany> companyList;
    List<ResponseProduct> productList;
    ResponseUser responseUser;
}
