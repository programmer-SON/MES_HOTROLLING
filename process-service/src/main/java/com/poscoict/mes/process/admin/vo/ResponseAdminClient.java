package com.poscoict.mes.process.admin.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseAdminClient {
	
	private String clientId;
	private String clientName;
	private String clientEmail;
	private String clientNumber;
	private Date clientUpdate;
	
}
