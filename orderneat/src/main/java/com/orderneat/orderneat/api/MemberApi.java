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

    @PostMapping("/api/v2/members")
    public MemberJoinResponse saveMemberV2(@RequestBody @Valid MemberJoinRequest request){
        Member member = Member.builder()
                .email(request.email)
                .password(request.password).build();
        Long id = memberService.join(member);
        return new MemberJoinResponse(id);
    }
    @Data
    static class MemberJoinResponse{
        private Long id;

        public MemberJoinResponse(Long id) {
            this.id = id;
        }
    }

    @Data
    static class MemberJoinRequest{

        @NotEmpty
        private String email;

        @NotEmpty
        private String password;
    }
}
