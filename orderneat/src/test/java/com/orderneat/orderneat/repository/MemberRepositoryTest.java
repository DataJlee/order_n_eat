package com.orderneat.orderneat.repository;

import com.orderneat.orderneat.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void findMemberByEmail(){
        //given
        String email = "jaek1997@gmail.com";
        Member member = createMember(email, "1234");
        memberRepository.save(member);
        //when
        Optional<Member> memberFoundByEmail = memberRepository.findMemberByEmail(email);
        //then
        assertEquals(memberFoundByEmail.get(), member);
    }

    // 사용자 정의 START
    private Member createMember(String username, String password) {
        Member member = Member.builder()
                .email(username)
                .password(password)
                .build();
        return member;
    }

    // 사용자 정의 END
}