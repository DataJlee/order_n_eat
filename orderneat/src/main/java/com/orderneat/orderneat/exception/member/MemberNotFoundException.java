package com.orderneat.orderneat.exception.member;

public class MemberNotFoundException extends IllegalStateException{

    private static final String EXCEPTION_MESSAGE = "존재하지 않는 회원입니다.";

    public MemberNotFoundException(){
        super(EXCEPTION_MESSAGE);
    }
}
