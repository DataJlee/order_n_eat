package com.orderneat.orderneat.controller;

import com.orderneat.orderneat.domain.Member;
import com.orderneat.orderneat.dto.MemberJoinFormDTO;
import com.orderneat.orderneat.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@Transactional
public class StoreMemberControllerTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Member createMember(String email, String password){
        MemberJoinFormDTO memberJoinFormDTO = new MemberJoinFormDTO();
        memberJoinFormDTO.setEmail(email);
        memberJoinFormDTO.setPassword(password);
        memberJoinFormDTO.setName("이재경");
        memberJoinFormDTO.setPostalCode("12621");
        memberJoinFormDTO.setAddress1("경기도 용인시 기흥구");
        memberJoinFormDTO.setAddress2("123-123");
        Member createdMember = Member.createMember(memberJoinFormDTO, passwordEncoder);
        memberService.join(createdMember);
        return createdMember;
    }

    @Test
    public void loginSuccessTest() throws Exception{
        String email = "emailtest123@gmail.com";
        String password = "123123";

        this.createMember(email, password);

        mockMvc.perform(formLogin().userParameter("email")
                .loginProcessingUrl("/member/login")
                .user(email).password(password))
                .andExpect(SecurityMockMvcResultMatchers.authenticated());
    }

    @Test
    public void loginFailureTest() throws Exception{
        String email = "emailtest123@gmail.com";
        String password = "1231233";
        this.createMember(email, password);

        mockMvc.perform(formLogin().userParameter("email")
                        .loginProcessingUrl("/member/login")
                        .user(email).password("1234"))
                .andExpect(SecurityMockMvcResultMatchers.unauthenticated());
    }
}
