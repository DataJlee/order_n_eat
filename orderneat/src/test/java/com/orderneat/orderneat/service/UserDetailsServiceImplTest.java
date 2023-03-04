package com.orderneat.orderneat.service;

import com.orderneat.orderneat.dto.member.MemberJoinRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDetailsServiceImplTest {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    MemberService memberService;

    @Test
    void loadUserByUsername() {
        //given
        memberService.join(new MemberJoinRequest("test@naver.com", "123"));
        //when
        UserDetails userDetails = userDetailsService.loadUserByUsername("test@naver.com");
        //then
        assertEquals(userDetails.getUsername(), "test@naver.com");
    }
}