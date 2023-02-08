package com.orderneat.orderneat.service;

import com.orderneat.orderneat.domain.Member;
import com.orderneat.orderneat.dto.member.MemberJoinRequest;
import com.orderneat.orderneat.dto.member.MemberJoinResponse;
import com.orderneat.orderneat.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberService memberService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void join() throws Exception{
        //given
        MemberJoinRequest req = new MemberJoinRequest();
        req.setEmail("jaek1994@gmail.com");
        req.setPassword("1234");
        Member member = Member.createMember(req, passwordEncoder);
        //when
        MemberJoinResponse res = memberService.join(req);
    }

    @Test(expected = IllegalStateException.class)
    public void validateDuplicateMember() throws Exception{
        //given
        MemberJoinRequest req = new MemberJoinRequest();
        req.setEmail("jaek1997@gmail.com");
        req.setPassword("1234");
        MemberJoinRequest req2 = new MemberJoinRequest();
        req.setEmail("jaek1997@gmail.com");
        req.setPassword("1234");
        //when
        memberService.join(req);
        memberService.join(req2);
        //then
        fail("예외 발생 x, 테스트 실패");
    }
}