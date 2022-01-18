package com.poscoict.mes.user.admin.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.List;

@Data
public class RequestChecks {

    private List<String> checks;
}
