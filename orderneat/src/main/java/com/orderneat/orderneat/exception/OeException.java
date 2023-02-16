package com.orderneat.orderneat.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class OeException extends RuntimeException{

    private static final String DEFAULT_MESSAGE = "일시적인 시스템 문제로 접속이 원활하지 않습니다. 잠시후에 이용해주세요.";
    private final HttpStatus httpStatus;

    public OeException(){
        super(DEFAULT_MESSAGE);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public OeException(String message, HttpStatus httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }
}

