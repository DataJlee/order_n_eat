package com.orderneat.orderneat.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Store extends BaseTimeEntity{

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

    public boolean isOpen(){
        boolean isOpen = false;
        if (status == StoreStatus.OPEN) {
            isOpen = true;
        }
        else if (status == StoreStatus.CLOSED) {
            isOpen = false;
        }
        return isOpen;
    }
}
