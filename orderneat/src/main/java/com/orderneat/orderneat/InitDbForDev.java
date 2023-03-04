package com.orderneat.orderneat;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class InitDbForDev {

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
//            Member member1 = new Member("jaek1997@gmail.com", "$2a$10$/Ixv2xzNCMKfCTq/WRaxkeONZA7cZV74CwqFNwwbKjaCEXa5BpXLe", Role.ROLE_USER);
//            Member member2 = new Member("chlee1998@naver.com", "$2a$10$/Ixv2xzNCMKfCTq/WRaxkeONZA7cZV74CwqFNwwbKjaCEXa5BpXLe", Role.ROLE_USER);
//            Member member3 = new Member("sangsimk@gmail.com", "$2a$10$/Ixv2xzNCMKfCTq/WRaxkeONZA7cZV74CwqFNwwbKjaCEXa5BpXLe", Role.ROLE_USER);
//            em.persist(member1);
//            em.persist(member2);
//            em.persist(member3);
        }



    }
}

