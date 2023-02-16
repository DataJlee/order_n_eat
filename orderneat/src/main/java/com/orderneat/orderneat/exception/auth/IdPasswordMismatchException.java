package com.orderneat.orderneat.exception.auth;

public class IdPasswordMismatchException extends RuntimeException{

    private static final String EXCEPTION_MESSAGE = "이메일 혹은 비밀번호를 확인해주세요.";

    public IdPasswordMismatchException(){
        super(EXCEPTION_MESSAGE);
    }
}
