package com.orderneat.orderneat.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "orders")
public class Order extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderLine> orderLines = new ArrayList<>();

    protected Order(){
    }

    //연관관계 편의 메서드
    public void addOrderLine(OrderLine orderLine){
        orderLines.add(orderLine);
        orderLine.setOrder(this);
    }

    public static Order createOrder(Member member, Store store, OrderLine... orderLines){
        Order order = new Order();
        order.setMember(member);
        order.setStore(store);

        for (OrderLine orderLine : orderLines){
            order.addOrderLine(orderLine);
        }
        order.setStatus(OrderStatus.ORDERED);
        return order;
    }

    public void cancelOrder(){
        this.setStatus(OrderStatus.CANCELED);
    }

    public int getTotalPrice(){
        int totalPrice = 0;

        for (OrderLine orderLine : orderLines){
            totalPrice += orderLine.getTotalPrice();
        }

        return totalPrice;
    }
}
