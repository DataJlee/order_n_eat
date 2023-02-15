package com.orderneat.orderneat.service;

import com.orderneat.orderneat.domain.Member;
import com.orderneat.orderneat.domain.Role;
import com.orderneat.orderneat.dto.member.MemberJoinRequest;
import com.orderneat.orderneat.exception.member.DuplicateMemberException;
import com.orderneat.orderneat.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


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
    public void join() {
        //given
        MemberJoinRequest req = new MemberJoinRequest();
        req.setEmail("new@gmail.com");
        req.setPassword("pass1234");
        //when
        Long savedId = memberService.join(req);
        //then
        assertEquals(savedId, memberRepository.findOne(savedId).getId());
    }

    @Test(expected = DuplicateMemberException.class)
    public void validateDuplicateMember() throws DuplicateMemberException {
        //given
        MemberJoinRequest req = new MemberJoinRequest();
        req.setEmail("jaek1997@gmail.com");
        req.setPassword("1234");

        memberService.join(req);
        //when
        MemberJoinRequest req2 = new MemberJoinRequest();
        req2.setEmail("jaek1997@gmail.com");
        req2.setPassword("1234");

        Member member2 = Member.builder()
                .email(req2.getEmail())
                .password(passwordEncoder.encode(req2.getPassword()))
                .role(Role.USER)
                .build();

        memberService.join(req2);

        memberService.validateDuplicateMember(member2);
        //then
        fail("예외 발생 x, 테스트 실패");
    }
}