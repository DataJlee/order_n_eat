package com.orderneat.orderneat.service;

import com.orderneat.orderneat.domain.Member;
import com.orderneat.orderneat.dto.member.MemberLoginRequest;
import com.orderneat.orderneat.exception.auth.IdPasswordMismatchException;
import com.orderneat.orderneat.infrastructure.auth.JwtUtils;
import com.orderneat.orderneat.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final MemberRepository memberRepository;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public String login(MemberLoginRequest request) {

        List<Member> member = memberRepository.findByEmail(request.getEmail());

        if (member.isEmpty()){
            throw new IdPasswordMismatchException();
        }

        String token = issueToken(member.get(0));
        validatePassword(member.get(0), request.getPassword());
        return token;
    }

    private void validatePassword(Member member, String password) {

        if (!passwordEncoder.matches(password, member.getPassword())){
            throw new IdPasswordMismatchException();
        }
    }

    private String issueToken(Member member) {

        Map<String, Object> payload = JwtUtils.payloadBuilder()
                .setSubject(member.getEmail())
                .build();
        return jwtUtils.createToken(payload);
    }


}
