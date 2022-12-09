package com.orderneat.orderneat.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Menu extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    private String category;

    private Integer price;

//    private String menuImgUrl;

    private String desc;

    @Enumerated(EnumType.STRING)
    private MenuStatus status;

    public Menu(Store store, String category, Integer price, String desc, MenuStatus status){
        this.store = store;
        this.category = category;
        this.price = price;
        this.desc = desc;
        this.status = status;
    }
}
