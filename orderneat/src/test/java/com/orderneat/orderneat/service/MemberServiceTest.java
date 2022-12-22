package com.orderneat.orderneat.service;

import com.orderneat.orderneat.domain.Member;
import com.orderneat.orderneat.dto.MemberJoinFormDTO;
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

    public Member createMember(){
        MemberJoinFormDTO memberJoinFormDTO = new MemberJoinFormDTO();
        memberJoinFormDTO.setEmail("emailtest123@gmail.com");
        memberJoinFormDTO.setName("이재경");
        memberJoinFormDTO.setPassword("123123abb!!");
        memberJoinFormDTO.setPostalCode("12345");
        memberJoinFormDTO.setAddress1("경기도 용인시 기흥구");
        memberJoinFormDTO.setAddress2("12-121");
        Member createdMember = Member.createMember(memberJoinFormDTO, passwordEncoder);
        return createdMember;
    }

    @Test
    public void join() throws Exception{
        //given
        Member newMember = createMember();
        //when
        Long savedId = memberService.join(newMember);
        //then
        assertEquals(newMember, memberRepository.findOne(savedId));
    }

    @Test(expected = IllegalStateException.class)
    public void validateDuplicateMember() throws Exception{
        //given
        Member member1 = createMember();
        Member member2 = createMember();
        //when
        memberService.join(member1);
        memberService.join(member2);
        //then
        fail("예외 발생 x, 테스트 실패");
    }
}