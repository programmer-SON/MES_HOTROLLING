package com.poscoict.mes.user.vo;

import lombok.Data;

@Data
public class RequestUser {
    private String userId;
    private String password;
    private String name;
    private Integer phone;
}
