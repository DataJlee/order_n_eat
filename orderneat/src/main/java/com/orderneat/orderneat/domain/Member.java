package com.orderneat.orderneat.domain;

import com.orderneat.orderneat.dto.MemberJoinFormDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Getter
public class Member extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public Member(String email, String password, Role role){
        this.email = email;
        this.password = password;
        this.role = role;
    }

    protected Member() {
    }

    public static Member createMember(MemberJoinFormDTO memberJoinFormDTO, PasswordEncoder passwordEncoder){
        Member member = Member.builder()
                .email(memberJoinFormDTO.getEmail())
                .password(passwordEncoder.encode(memberJoinFormDTO.getPassword()))
                .role(Role.USER)
                .build();
        return member;
    }


}
