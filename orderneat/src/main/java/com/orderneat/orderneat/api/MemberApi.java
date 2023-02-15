package com.orderneat.orderneat.api;

import com.orderneat.orderneat.dto.auth.TokenResponse;
import com.orderneat.orderneat.dto.member.MemberJoinRequest;
import com.orderneat.orderneat.dto.member.MemberJoinResponse;
import com.orderneat.orderneat.dto.member.MemberLoginRequest;
import com.orderneat.orderneat.service.AuthService;
import com.orderneat.orderneat.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/member")
public class MemberApi {

    private final MemberService memberService;
    private final AuthService authService;

    @PostMapping("/v1.0/join")
    public ResponseEntity<MemberJoinResponse> joinMemberByEmail(@RequestBody @Valid MemberJoinRequest request){

        Long id = memberService.join(request);
        MemberJoinResponse response = new MemberJoinResponse();
        response.setId(id);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/v1.0/login")
    public ResponseEntity<TokenResponse> loginMemberByEmail(@RequestBody @Valid MemberLoginRequest request){
        String token = authService.login(request);
        TokenResponse response = new TokenResponse(token);

        return ResponseEntity.ok()
                .body(response);
    }


















}
