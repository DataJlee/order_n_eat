package com.orderneat.orderneat.domain;

import com.orderneat.orderneat.dto.MemberJoinFormDTO;
import com.orderneat.orderneat.dto.member.MemberJoinRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberTest {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void createMemberTest(){
        MemberJoinRequest memberJoinRequest = new MemberJoinRequest();
        memberJoinRequest.setEmail("jaek1997@gmail.con");
        memberJoinRequest.setPassword("123123");
        Member createdMember = Member.createMember(memberJoinRequest, passwordEncoder);
        System.out.println(createdMember.getEmail());
    }
}
