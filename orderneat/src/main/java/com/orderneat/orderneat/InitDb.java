package com.orderneat.orderneat;

import com.orderneat.orderneat.domain.Member;
import com.orderneat.orderneat.domain.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.initDb1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;
        public void initDb1(){
            Member member1 = new Member("jaek1997@gmail.com", "12345", Role.USER);
            Member member2 = new Member("chlee1998@naver.com", "123455", Role.USER);
            Member member3 = new Member("sansimk@gmail.com", "1234", Role.USER);
            em.persist(member1);
            em.persist(member2);
            em.persist(member3);
        }



    }
}

