package com.orderneat.orderneat.dto.store;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
public class StoreRegisterResponse {

    private Long id;

    protected StoreRegisterResponse(){
    }

    public StoreRegisterResponse(Long id){
        this.id = id;
    }
}
