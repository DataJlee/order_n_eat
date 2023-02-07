package com.orderneat.orderneat.domain;

import com.orderneat.orderneat.dto.StoreRegistFormDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Store extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "store_id")
    private Long id;

    @Column(name = "store_name")
    private String name;

    @Column(name = "store_category")
    private String category;

    @Embedded
    private Address address;

    @Column(name = "store_contact")
    private String contact;

    @Enumerated(EnumType.STRING)
    @Column(name = "store_status")
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

    @Builder
    public Store(Long id, String name, String category, String contact, Address address) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.contact = contact;
        this.address = address;
        this.status = StoreStatus.OPEN;
    }

    public static Store createStore(StoreRegistFormDTO storeRegistFormDTO){
        Address address = new Address(storeRegistFormDTO.getPostalCd(),
                storeRegistFormDTO.getAddress1(), storeRegistFormDTO.getAddress2());
        Store store = Store.builder()
                .name(storeRegistFormDTO.getName())
                .category(storeRegistFormDTO.getCategory())
                .contact(storeRegistFormDTO.getContact())
                .address(address)
                .build();
        return store;
    }
}
