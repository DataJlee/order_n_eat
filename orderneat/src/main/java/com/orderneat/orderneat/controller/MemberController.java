package com.orderneat.orderneat.controller;

import com.orderneat.orderneat.domain.Member;
import com.orderneat.orderneat.dto.MemberJoinFormDTO;
import com.orderneat.orderneat.dto.StoreRegistFormDTO;
import com.orderneat.orderneat.service.MemberService;
import com.orderneat.orderneat.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j

public class StoreMemberController {

    public final MemberService memberService;
    public final StoreService storeService;
    public final PasswordEncoder passwordEncoder;

    @GetMapping("/store_member/login")
    public String login(){
        return "store_member/member-login-pg";
    }

    @GetMapping("/store_member/login/error")
    public String loginError(Model model){
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");
        return "store_member/member-login-pg";
    }

    @GetMapping("/store_member/join")
    public String joinForm(Model model){
        model.addAttribute("memberJoinFormDto", new MemberJoinFormDTO());
        return "store_member/member-join-pg";
    }

    @PostMapping("/store_member/join")
    public String memberJoin(@ModelAttribute("memberJoinFormDto") @Valid MemberJoinFormDTO memberJoinFormDto, BindingResult bindingResult, Model model){
        log.info("회원가입 페이지 가입하기 SUBMIT");
        if (bindingResult.hasErrors()){
            log.info(bindingResult.toString());
            return "store_member/member-join-pg";
        }
        try{
            Member member = Member.createMember(memberJoinFormDto, passwordEncoder);
            memberService.join(member);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "store_member/member-join-pg";
        }
        return "store_member/member-join-success-pg";
    }

    @GetMapping("/store_member/manage")
    public String managePage(){
        return "store_member/store-manage-page";
    }


    @GetMapping("/store_member/manage/store_info")
    public String storeRegistForm(Model model, HttpServletRequest httpServletRequest){
        model.addAttribute("storeRegistFormDto", new StoreRegistFormDTO());
        return "store_member/store-info-manage-pg";
    }

//    @PostMapping("/store_member/manage/store_info")
//    public String storeInfo(@ModelAttribute("storeRegistFormDto") StoreRegistFormDTO storeRegistFormDto){
//
//    }

}
