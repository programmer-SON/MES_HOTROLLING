package com.poscoict.mes.user.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseLogin {
    @NotNull
    private String userId;
    private String password;
}
