package com.orderneat.orderneat.service;

import com.orderneat.orderneat.domain.Member;
import com.orderneat.orderneat.dto.member.MemberJoinRequest;
import com.orderneat.orderneat.dto.store.StoreRegisterRequest;
import com.orderneat.orderneat.repository.StoreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StoreServiceTest {

    @Autowired
    StoreService storeService;
    @Autowired
    MemberService memberService;
    @Autowired
    StoreRepository storeRepository;

    @Test
    @Transactional
    void save() {
        //given
        Long id = memberService.join(new MemberJoinRequest("jaek997", "1234"));
        Member member = memberService.findMemberByEmail("jaek997");
        //when
        Long savedId = storeService.save(member, new StoreRegisterRequest("하남돼지식당", "정육점", "서울시", "010"));

        //then
        assertEquals(savedId, storeRepository.findById(savedId).get().getId());
    }
}