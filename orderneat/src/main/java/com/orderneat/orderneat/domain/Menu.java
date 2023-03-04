package com.orderneat.orderneat.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Menu extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(name = "menu_category")
    private String category;

    @Column(name = "menu_name")
    private String name;

    @Column(name = "menu_price")
    private Integer price;

    @Column(name = "menu_img_url")
    private String imgUrl;

    @Column(name = "menu_desc")
    private String desc;

    @Enumerated(EnumType.STRING)
    @Column(name = "menu_status")
    private MenuStatus status;

    @Builder
    public Menu(Store store, String category, String name, Integer price, String imgUrl, String desc, MenuStatus status) {
        this.store = store;
        this.category = category;
        this.name = name;
        this.price = price;
        this.imgUrl = imgUrl;
        this.desc = desc;
        this.status = status;
    }

    protected Menu(){
    }
}
