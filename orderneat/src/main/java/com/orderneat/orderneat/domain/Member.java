package com.orderneat.orderneat.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Member extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    private String password;

    private String gender;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Member(String email, String password, String gender, Integer age){
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.role = Role.USER;
    }

    public Member(String email, String password, String gender){
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.role = Role.USER;
    }

    public Member(String email, String password, Integer age){
        this.email = email;
        this.password = password;
        this.age = age;
        this.role = Role.USER;
    }

    public Member(String email, String password){
        this.email = email;
        this.password = password;
        this.role = Role.USER;
    }

    protected Member() {
    }
}
