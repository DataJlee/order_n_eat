package com.orderneat.orderneat.repository;

import com.orderneat.orderneat.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryLegacy {

    private final EntityManager em;

    @Transactional
    public Member save(Member member){
        em.persist(member);
        return member;

    }

    public Member findOne(Long id){
        return em.find(Member.class, id);
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    //단건 조회를 할 수 있지만 반환값이 없을 경우 예외처리가 까다로워 컬렉션으로 조회한다
    public List<Member> findByEmail(String email){
        return em.createQuery("select m from Member m where m.email = :email", Member.class)
                .setParameter("email", email)
                .getResultList();
    }


}
