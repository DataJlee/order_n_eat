package com.orderneat.orderneat.repository;

import com.orderneat.orderneat.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface StoreRepository extends JpaRepository<Store, Long> {

    Optional<Store> findStoreByMemberId(Long id);
}
