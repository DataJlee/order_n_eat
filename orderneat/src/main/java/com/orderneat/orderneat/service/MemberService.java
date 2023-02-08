package com.orderneat.orderneat.service;

import com.orderneat.orderneat.domain.Member;
import com.orderneat.orderneat.domain.Role;
import com.orderneat.orderneat.dto.member.MemberJoinRequest;
import com.orderneat.orderneat.dto.member.MemberJoinResponse;
import com.orderneat.orderneat.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public MemberJoinResponse join(final MemberJoinRequest memberJoinRequest){
        Member member = Member.builder()
                    .email(memberJoinRequest.getEmail())
                    .password(passwordEncoder.encode(memberJoinRequest.getPassword()))
                    .role(Role.USER)
                    .build();
        validateDuplicateMember(member);
        memberRepository.save(member);
        MemberJoinResponse memberJoinResponse = new MemberJoinResponse();
        memberJoinResponse.setId(member.getId());
        return memberJoinResponse;
    }

    private void validateDuplicateMember(Member member) {
        List<Member> memberByEmail = memberRepository.findByEmail(member.getEmail());
        if (!memberByEmail.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public List<Member> findAllMembers(){
        return memberRepository.findAll();
    }

    public Member findMember(Long id){
        return memberRepository.findOne(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        List<Member> member = memberRepository.findByEmail(email);
        Member memberFound = member.get(0);
        if (member.isEmpty()){
            throw new UsernameNotFoundException(email);
        }
        return User.builder()
                .username(memberFound.getEmail())
                .password(memberFound.getPassword())
                .roles(memberFound.getRole().toString())
                .build();
    }
}
