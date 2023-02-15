package com.orderneat.orderneat.service;

import com.orderneat.orderneat.domain.Member;
import com.orderneat.orderneat.domain.Role;
import com.orderneat.orderneat.dto.member.MemberJoinRequest;
import com.orderneat.orderneat.exception.member.DuplicateMemberException;
import com.orderneat.orderneat.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService{

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long join(final MemberJoinRequest memberJoinRequest) {

        Member member = Member.builder()
                    .email(memberJoinRequest.getEmail())
                    .password(passwordEncoder.encode(memberJoinRequest.getPassword()))
                    .role(Role.USER)
                    .build();
        validateDuplicateMember(member);
        memberRepository.save(member);

        return member.getId();
    }

    public void validateDuplicateMember(Member member) {

        List<Member> memberByEmail = memberRepository.findByEmail(member.getEmail());
        if (!memberByEmail.isEmpty()){
            throw new DuplicateMemberException();
        }
    }




}
