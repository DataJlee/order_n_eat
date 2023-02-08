package com.orderneat.orderneat.api;

import com.orderneat.orderneat.domain.Member;
import com.orderneat.orderneat.domain.Role;
import com.orderneat.orderneat.dto.member.MemberJoinRequest;
import com.orderneat.orderneat.dto.member.MemberJoinResponse;
import com.orderneat.orderneat.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberApi {

    private final MemberService memberService;

    @PostMapping("/member/v1.0/join")
    public ResponseEntity<MemberJoinResponse> joinMemberByEmail(@RequestBody @Valid MemberJoinRequest request){
        MemberJoinResponse response = memberService.join(request);
        return ResponseEntity.ok(response);
    }
}
