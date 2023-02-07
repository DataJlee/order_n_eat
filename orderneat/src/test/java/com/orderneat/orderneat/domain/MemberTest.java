package com.orderneat.orderneat.domain;

import com.orderneat.orderneat.dto.MemberJoinFormDTO;
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
        MemberJoinFormDTO memberJoinFormDTO = new MemberJoinFormDTO();
        memberJoinFormDTO.setEmail("jaek1997@gmail.con");
        memberJoinFormDTO.setPassword("123123");
        memberJoinFormDTO.setName("이재경");
        memberJoinFormDTO.setPostalCode("12621");
        memberJoinFormDTO.setAddress1("경기도 용인시 기흥구");
        memberJoinFormDTO.setAddress2("123-123");
        Member createdMember = Member.createMember(memberJoinFormDTO, passwordEncoder);
        System.out.println(createdMember.getEmail());
    }
}
