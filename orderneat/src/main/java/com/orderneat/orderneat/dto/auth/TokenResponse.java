package com.orderneat.orderneat.dto.auth;

import lombok.Getter;

@Getter
public class TokenResponse {

    private String token;

    public TokenResponse(String token){
        this.token = token;
    }
}
