package com.orderneat.orderneat.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
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

    private String category;

    private String name;

    private Integer price;

    private String imgUrl;

    private String desc;

    @Enumerated(EnumType.STRING)
    private MenuStatus status;

    protected Menu(){
    }

    public static Menu createMenu(Store store, String category, String name, Integer price, String imgUrl, String desc){
        Menu menu = new Menu();
        menu.setStore(store);
        menu.setCategory(category);
        menu.setName(name);
        menu.setPrice(price);
        menu.setImgUrl(imgUrl);
        menu.setDesc(desc);
        menu.setStatus(MenuStatus.AVAILABLE);

        return menu;
    }
}
