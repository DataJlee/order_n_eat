package com.orderneat.orderneat.api;

import com.orderneat.orderneat.dto.member.MemberJoinRequest;
import com.orderneat.orderneat.dto.member.MemberJoinResponse;
import com.orderneat.orderneat.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberApi {

    private final MemberService memberService;

    @PostMapping("/api/member/v1.0/join")
    public ResponseEntity<MemberJoinResponse> joinMemberByEmail(@RequestBody @Valid MemberJoinRequest request){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/member/v1.0/join").toUriString());
        Long id = memberService.join(request);
        MemberJoinResponse response = new MemberJoinResponse();
        response.setId(id);

        return ResponseEntity.created(uri).body(response);
    }
}
