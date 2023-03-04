package com.orderneat.orderneat.api;

import com.orderneat.orderneat.domain.Member;
import com.orderneat.orderneat.dto.store.StoreRegisterRequest;
import com.orderneat.orderneat.dto.store.StoreRegisterResponse;
import com.orderneat.orderneat.exception.auth.InvalidTokenException;
import com.orderneat.orderneat.service.MemberService;
import com.orderneat.orderneat.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@Slf4j
@RequiredArgsConstructor
public class StoreApi {

    private final StoreService storeService;
    private final MemberService memberService;

    @PostMapping("/api/store/v1.0/register")
    public ResponseEntity<StoreRegisterResponse> registerStore(Principal user, @RequestBody @Valid StoreRegisterRequest request) {
        log.info("========== Store Register Request =========");
        if (user == null) {
            throw new InvalidTokenException();
        }
        Member memberLoggedIn = memberService.findMemberByEmail(user.getName());
        Long savedStoreId = storeService.save(memberLoggedIn, request);
        StoreRegisterResponse response = new StoreRegisterResponse(savedStoreId);

        return ResponseEntity.ok().body(response);
    }
}
