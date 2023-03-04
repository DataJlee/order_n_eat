package com.orderneat.orderneat.service;


import com.orderneat.orderneat.domain.Member;
import com.orderneat.orderneat.dto.member.MemberJoinRequest;
import com.orderneat.orderneat.exception.member.DuplicateMemberException;
import com.orderneat.orderneat.exception.member.MemberNotFoundException;
import com.orderneat.orderneat.repository.MemberRepositoryLegacy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberRepositoryLegacy memberRepository;
    @Autowired
    MemberService memberService;

    @Test
    public void join() throws DuplicateMemberException {
        //given
        MemberJoinRequest request = createMemberJoinRequest("test@email.com", "1234");
        //when
        Long savedId = memberService.join(request);
        //then
        assertMemberIsJoined(savedId);
    }

    @Test
    public void validateDuplicateMember() {
        //given
        MemberJoinRequest request = createMemberJoinRequest("test@email.com", "1234");
        memberService.join(request);
        //when
        MemberJoinRequest sameRequest = createMemberJoinRequest("test@email.com", "1234");

        //then
        assertThrows(DuplicateMemberException.class, ()-> memberService.join(sameRequest));
    }

    @Test
    void findMemberByEmail() {
        //given
        //when
        Long joinedId = memberService.join(createMemberJoinRequest("test@email.com", "1234"));
        Member memberFound = memberService.findMemberByEmail("test@email.com");
        //then
        assertEquals(joinedId, memberFound.getId());
        assertThrows(MemberNotFoundException.class, ()-> memberService.findMemberByEmail("no@naver.com"));
    }

    //    사용자메서드 START
    MemberJoinRequest createMemberJoinRequest(String email, String password){
        MemberJoinRequest req = new MemberJoinRequest(email, password);
        return req;
    }

    void assertMemberIsJoined(Long id) {
        assertEquals(id, memberRepository.findOne(id).getId());
    }
    //    사용자메서드 END
}