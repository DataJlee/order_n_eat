package com.orderneat.orderneat.dto.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter @Setter
@RequiredArgsConstructor
public class MemberJoinRequest {

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String password;
}
