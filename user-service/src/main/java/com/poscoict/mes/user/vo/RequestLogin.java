package com.poscoict.mes.user.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RequestLogin {
    @NotNull
    private String userId;

    private String password;
}
