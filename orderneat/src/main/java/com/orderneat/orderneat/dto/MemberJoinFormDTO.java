package com.orderneat.orderneat.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberJoinFormDTO {

    @NotEmpty(message="회원 이메일은 필수 입니다.")
    private String email;

    @NotEmpty(message="회원 이름은 필수 입니다.")
    private String name;

    @NotEmpty(message="회원 비밀번호는 필수 입니다.")
    private String password;

    @NotEmpty(message="회원 우편번호는 필수 입니다.")
    private String postalCode;

    @NotEmpty(message="회원 주소는 필수 입니다.")
    private String address1;

    private String address2;
}
