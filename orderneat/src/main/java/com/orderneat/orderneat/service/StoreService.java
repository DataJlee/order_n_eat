package com.orderneat.orderneat.service;


import com.orderneat.orderneat.domain.Store;
import com.orderneat.orderneat.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreService {

    private final StoreRepository storeRepository;

    @Transactional
    public void save(Store store){
        storeRepository.save(store);
    }


}
