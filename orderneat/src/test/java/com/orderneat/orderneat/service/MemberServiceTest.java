package com.orderneat.orderneat.service;

import com.orderneat.orderneat.domain.Member;
import com.orderneat.orderneat.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

    public final String EMAIL = "testemail@naver.com";
    public final String PASSWORD = "PASSWORD123";
    public final String GENDER = "M";
    public final Integer AGE = 21;

    @Test
    public void join() throws Exception{
        //given
        Member newMember = new Member(
                EMAIL, PASSWORD, GENDER, AGE
        );
        //when
        Long savedId = memberService.join(newMember);
        //then
        assertEquals(newMember, memberRepository.fineOne(savedId));
    }

    @Test(expected = IllegalStateException.class)
    public void validateDuplicateMember() throws Exception{
        //given
        Member member1 = new Member(EMAIL, PASSWORD);
        Member member2 = new Member(EMAIL, PASSWORD);
        //when
        memberService.join(member1);
        memberService.join(member2);
        //then
        fail("예외 발생 x, 테스트 실패");
    }
}