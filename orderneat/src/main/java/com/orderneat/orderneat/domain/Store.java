package com.orderneat.orderneat.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static com.orderneat.orderneat.domain.StoreStatus.*;

@Entity
@Getter @Setter
public class Store extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "store_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String name;

    private String category;

//    @Embedded
//    private Address address;
    private String address;

    private String contact;

    @Enumerated(EnumType.STRING)
    private StoreStatus status;

    public boolean isOpen(){
        boolean isOpen = status == OPEN;
        return isOpen;
    }

    protected Store(){
    }

    @Builder
    public Store(Long id, Member member, String name, String category, String contact, String address) {
        this.id = id;
        this.member = member;
        this.name = name;
        this.category = category;
        this.contact = contact;
        this.address = address;
        this.status = OPEN;
    }

//    public static Store createStore(StoreRegistFormDTO storeRegistFormDTO){
//        Address address = new Address(storeRegistFormDTO.getPostalCd(),
//                storeRegistFormDTO.getAddress1(), storeRegistFormDTO.getAddress2());
//        Store store = Store.builder()
//                .name(storeRegistFormDTO.getName())
//                .category(storeRegistFormDTO.getCategory())
//                .contact(storeRegistFormDTO.getContact())
//                .address(address)
//                .build();
//        return store;
//    }
}
