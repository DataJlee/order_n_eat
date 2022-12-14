package com.orderneat.orderneat.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class OrderLine extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_line_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @Column(name = "order_line_price")
    private int price;

    @Column(name = "order_line_quantity")
    private int quantity;

    public static OrderLine createOrderLine(Menu menu, int price, int quantity){
        OrderLine orderLine = new OrderLine();
        orderLine.setMenu(menu);
        orderLine.setPrice(price);
        orderLine.setQuantity(quantity);

        return orderLine;
    }

    public int getTotalPrice(){
        return getPrice() * getQuantity();
    }
}
