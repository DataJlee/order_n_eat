package com.orderneat.orderneat.controller;

import com.orderneat.orderneat.domain.Address;
import com.orderneat.orderneat.domain.Member;
import com.orderneat.orderneat.dto.MemberJoinFormDTO;
import com.orderneat.orderneat.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/member")
public class MemberController {

    public final MemberService memberService;

    public final PasswordEncoder passwordEncoder;

    @GetMapping("/memberInfo")
    public String memberInfo(Model model){
        log.info("called getMemberInfoPage()");
        //로그인 상태 아님
        if (true){
            log.info("로그인 상태 아님 : loginPage로 redirect 중..");
            return "redirect:/member/login";
        }else{
            log.info("로그인 상태 완료 : memberInfoPage 가져오는중..");
            return "member/memberInfoPage";
        }
    }

    @GetMapping("/login")
    public String login(ModelAndView mv){
        return "member/memberLoginPage";
    }

    @GetMapping("/join")
    public String joinForm(Model model){
        model.addAttribute("memberJoinFormDto", new MemberJoinFormDTO());
        return "member/memberJoinPage";
    }

    @PostMapping("/join")
    public String memberJoin(@ModelAttribute("memberJoinFormDto") @Valid MemberJoinFormDTO memberJoinFormDto, BindingResult bindingResult, Model model){
        log.info("회원가입 페이지 가입하기 SUBMIT");
        if (bindingResult.hasErrors()){
            log.info(bindingResult.toString());
            return "member/memberJoinPage";
        }
        try{
            Member member = Member.createMember(memberJoinFormDto, passwordEncoder);
            memberService.join(member);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "member/memberJoinPage";
        }
        return "/member/memberJoinSuccessPage";
    }


}
