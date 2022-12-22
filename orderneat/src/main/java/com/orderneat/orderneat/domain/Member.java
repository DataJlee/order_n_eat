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

    private String name;

    private String password;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public Member(String email, String name, String password, Address address){
        this.email = email;
        this.name = name;
        this.password = password;
        this.address = address;
        this.role = Role.USER;
    }

    protected Member() {
    }

    public static Member createMember(MemberJoinFormDTO memberJoinFormDTO, PasswordEncoder passwordEncoder){
        Address address = new Address(memberJoinFormDTO.getPostalCode(), memberJoinFormDTO.getAddress1(),
                memberJoinFormDTO.getAddress2());
        Member member = Member.builder()
                .email(memberJoinFormDTO.getEmail())
                .name(memberJoinFormDTO.getName())
                .password(passwordEncoder.encode(memberJoinFormDTO.getPassword()))
                .address(address)
                .build();
        return member;
    }
}
