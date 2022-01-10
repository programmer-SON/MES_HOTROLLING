package com.poscoict.mes.user.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseUser {

    private String userId;
    private String password;
    private String name;
    private Integer phone;
    private String email;
}
