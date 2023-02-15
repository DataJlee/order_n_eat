package com.orderneat.orderneat.dto.store;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
@RequiredArgsConstructor
public class StoreRegisterRequest {

    @NotEmpty
    private String storeName;

    @NotEmpty
    private String storeCategory;

    @NotEmpty
    private String storeAddress;

    @NotEmpty
    private String storeContact;
}
