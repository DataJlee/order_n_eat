package com.orderneat.orderneat.domain;


import lombok.Builder;
import lombok.Getter;


import javax.persistence.*;

@Entity
@Getter
public class Member extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public Member(String email, String password, Role role){
        this.email = email;
        this.password = password;
        this.role = role;
    }

    protected Member() {
    }
}
