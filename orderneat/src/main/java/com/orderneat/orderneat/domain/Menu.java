package com.orderneat.orderneat.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    private String category;

    private Integer price;

    private String menuImgUrl;

    private String desc;

}
