package com.orderneat.orderneat.service;

import com.orderneat.orderneat.domain.Member;
import com.orderneat.orderneat.exception.member.MemberNotFoundException;
import com.orderneat.orderneat.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws MemberNotFoundException {

        Optional<Member> member = memberRepository.findMemberByEmail(username);
        if (member.isEmpty()){
            throw new MemberNotFoundException();
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(member.get().getRole().toString()));
        return new User(member.get().getEmail(), member.get().getPassword(), authorities);
    }
}
