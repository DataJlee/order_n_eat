package com.orderneat.orderneat.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    private Integer orderPrice;

    private Integer orderQuantity;
}
