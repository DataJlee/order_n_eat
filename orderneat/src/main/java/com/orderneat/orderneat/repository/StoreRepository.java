package com.orderneat.orderneat.repository;

import com.orderneat.orderneat.domain.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class StoreRepository {

    private final EntityManager em;

    public void save(Store store){
        em.persist(store);
    }

    public Store findOne(Long id){
        return em.find(Store.class, id);
    }

    public List<Store> findAll(){
        return em.createQuery("select s from Store s")
                .getResultList();
    }
}
