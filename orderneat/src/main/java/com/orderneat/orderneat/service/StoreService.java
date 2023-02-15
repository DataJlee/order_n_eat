package com.orderneat.orderneat.service;


import com.orderneat.orderneat.domain.Store;
import com.orderneat.orderneat.dto.store.StoreRegisterRequest;
import com.orderneat.orderneat.dto.store.StoreRegisterResponse;
import com.orderneat.orderneat.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreService {

    private final StoreRepository storeRepository;

    @Transactional
    public StoreRegisterResponse save(final StoreRegisterRequest request) {
        Store store = Store.builder()
                .name(request.getStoreName())
                .category(request.getStoreCategory())
                .address(request.getStoreAddress())
                .address(request.getStoreContact())
                .build();
        storeRepository.save(store);
        StoreRegisterResponse response = new StoreRegisterResponse();
        response.setId(store.getId());
        return response;
    }


}