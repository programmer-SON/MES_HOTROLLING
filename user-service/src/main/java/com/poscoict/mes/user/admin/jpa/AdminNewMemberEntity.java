package com.poscoict.mes.user.admin.jpa;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@Table( name = "admin_new_member" )
public class AdminNewMemberEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String newMemberId;
	private String newMemberEmail;
	private String newMemberPw;
	private Date newMemberUpdate;
}
