package com.poscoict.mes.process.user.jpa;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table( name = "user" )
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String password;
    private String name;
    private Integer phone;
    private String email;
}
