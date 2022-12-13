package com.orderneat.orderneat.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
public class Member extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    private String email;

    private String password;

    private String gender;

    private String yearOfBirth;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public Member(String email, String password, String gender, String yearOfBirth){
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        this.role = Role.USER;
    }

    protected Member() {
    }
}
