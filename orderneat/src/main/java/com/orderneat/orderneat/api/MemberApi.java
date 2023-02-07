package com.orderneat.orderneat.api;

import com.orderneat.orderneat.domain.Member;
import com.orderneat.orderneat.service.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberApi {

    private final MemberService memberService;

    
}
