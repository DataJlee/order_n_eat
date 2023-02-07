package com.orderneat.orderneat.dto;

import com.orderneat.orderneat.domain.Address;
import com.orderneat.orderneat.domain.StoreStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StoreRegistFormDTO {

    private Long id;

    private String memberEmail;

    private String name;

    private String category;

    private String contact;

    private String postalCd;

    private String address1;

    private String address2;

    private StoreStatus status;
}
