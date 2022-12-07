package com.orderneat.orderneat.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
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

    @Enumerated(EnumType.STRING)
    private StoreStatus status;
}
