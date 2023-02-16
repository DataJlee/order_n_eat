package com.orderneat.orderneat.exception.member;

public class DuplicateMemberException extends IllegalStateException{

    private static final String EXCEPTION_MESSAGE = "이미 존재하는 회원입니다. 로그인 후 이용해주세요.";

    public DuplicateMemberException(){
        super(EXCEPTION_MESSAGE);
    }
}
