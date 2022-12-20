package com.orderneat.orderneat.controller;

import com.orderneat.orderneat.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    public final MemberService memberService;

    @GetMapping("/member/memberInfo")
    public ModelAndView getMemberInfoPage(ModelAndView mv){
        log.info("called getMemberInfoPage()");
        //로그인 상태 아님
        if (true){
            log.info("로그인 상태 아님 : loginPage로 redirect 중..");
            mv.setViewName("redirect:/member/login");
        }else{
            log.info("로그인 상태 완료 : memberInfoPage 가져오는중..");
            mv.setViewName("member/memberInfoPage");
        }
        return mv;
    }

    @GetMapping("member/login")
    public ModelAndView getMemberLoginPage(ModelAndView mv){
        mv.setViewName("member/memberLoginPage");
        return mv;
    }

    //회원가입 페이지
    @GetMapping("/member/join")
    public ModelAndView getMemberJoinPage(ModelAndView mv){
        mv.setViewName("member/memberJoinPage");
        return mv;
    }


}
