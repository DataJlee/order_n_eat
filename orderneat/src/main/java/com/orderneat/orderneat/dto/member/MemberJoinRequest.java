package com.orderneat.orderneat.dto.member;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
public class MemberJoinRequest {

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String password;

    public MemberJoinRequest(){}

    public MemberJoinRequest(String email, String password){
        this.email = email;
        this.password = password;
    }
}
