package com.orderneat.orderneat.service;


import com.orderneat.orderneat.domain.Member;
import com.orderneat.orderneat.domain.Store;
import com.orderneat.orderneat.dto.store.StoreRegisterRequest;
import com.orderneat.orderneat.dto.store.StoreRegisterResponse;
import com.orderneat.orderneat.exception.OeException;
import com.orderneat.orderneat.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class StoreService {

    private final StoreRepository storeRepository;

    @Transactional
    public Long save(Member member, StoreRegisterRequest request) {
        log.info("======== STORE SAVE REQUEST ========= {}", member.toString());
        if (member == null) {
            throw new OeException();
        }
        Store store = Store.builder()
                .name(request.getName())
                .member(member)
                .category(request.getCategory())
                .address(request.getAddress())
                .contact(request.getContact())
                .build();
        storeRepository.save(store);
        return store.getId();
    }

}