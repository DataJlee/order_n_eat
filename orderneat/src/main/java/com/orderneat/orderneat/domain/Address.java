package com.orderneat.orderneat.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    private String postalCode;

    private String address1;

    private String address2;

    protected Address() {
    }

    public Address(String postalCode, String address1, String address2) {
        this.postalCode = postalCode;
        this.address1 = address1;
        this.address2 = address2;
    }
}
