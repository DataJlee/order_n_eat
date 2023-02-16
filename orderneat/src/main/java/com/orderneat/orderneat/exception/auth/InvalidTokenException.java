package com.orderneat.orderneat.exception.auth;

import com.orderneat.orderneat.exception.OeException;
import org.springframework.http.HttpStatus;

public class InvalidTokenException extends OeException {

    private static final String EXCEPTION_MESSAGE = "로그인 후에 이용해주세요.";

    public InvalidTokenException() {
        super(EXCEPTION_MESSAGE, HttpStatus.UNAUTHORIZED);
    }
}
