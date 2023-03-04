package com.orderneat.orderneat.dto.store;

import lombok.Getter;
import javax.validation.constraints.NotEmpty;

@Getter
public class StoreRegisterRequest {

    @NotEmpty
    private String name;

    @NotEmpty
    private String category;

    private String address;

    @NotEmpty
    private String contact;

    protected StoreRegisterRequest(){}

    public StoreRegisterRequest(String name, String category, String address, String contact){
        this.name = name;
        this.category = category;
        this.address = address;
        this.contact = contact;
    }
}
