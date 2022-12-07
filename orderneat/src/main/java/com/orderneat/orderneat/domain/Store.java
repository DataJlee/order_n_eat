package com.orderneat.orderneat.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "store_id")
    private Long id;

    private String name;

    private String category;

    @Embedded
    private Address address;

    private String contact;

    private StoreStatus status;
}
