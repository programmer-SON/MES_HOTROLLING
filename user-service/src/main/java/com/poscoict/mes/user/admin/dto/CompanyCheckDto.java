package com.poscoict.mes.user.admin.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CompanyCheckDto implements Serializable {
    private List<String> checks;
}
