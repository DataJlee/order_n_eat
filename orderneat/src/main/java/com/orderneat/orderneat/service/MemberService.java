package com.orderneat.orderneat.service;

import com.orderneat.orderneat.domain.Member;
import com.orderneat.orderneat.domain.Role;
import com.orderneat.orderneat.dto.member.MemberJoinRequest;
import com.orderneat.orderneat.exception.member.DuplicateMemberException;
import com.orderneat.orderneat.exception.member.MemberNotFoundException;
import com.orderneat.orderneat.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long join(MemberJoinRequest memberJoinRequest) {

        Member member = Member.builder()
                    .email(memberJoinRequest.getEmail())
                    .password(passwordEncoder.encode(memberJoinRequest.getPassword()))
                    .role(Role.ROLE_USER)
                    .build();
        validateDuplicateMember(member);
        memberRepository.save(member);

        return member.getId();
    }

    public void validateDuplicateMember(Member member) {

        Optional<Member> memberByEmail = memberRepository.findMemberByEmail(member.getEmail());
        if (!memberByEmail.isEmpty()){
            throw new DuplicateMemberException();
        }
    }

    public Member findMemberByEmail(String email) {
        Optional<Member> member = memberRepository.findMemberByEmail(email);
        if (member.isEmpty()){
            throw new MemberNotFoundException();
        }
        return member.get();
    }
}
