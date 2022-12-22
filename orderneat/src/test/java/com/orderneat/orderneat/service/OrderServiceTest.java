package com.orderneat.orderneat.service;

import com.orderneat.orderneat.domain.*;
import com.orderneat.orderneat.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class OrderServiceTest {

    @Autowired
    EntityManager em;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;

    @Test
    public void order() {
        //given
        Member newMember = createDefaultMember();
        Store store = createDefaultStore();
        Menu menu = createDefaultMenu(store);

        int orderQuantity = 2;
        //when
        Long orderId = orderService.placeOrder(newMember.getId(), menu.getId(), store.getId(), orderQuantity);
        //then
        Order order = orderRepository.findOne(orderId);

        assertEquals(OrderStatus.ORDERED, order.getStatus());
        assertEquals(20000, order.getTotalPrice());
        assertEquals(1, order.getOrderLines().size());
        assertEquals("옥빈관", order.getStore().getName());
        assertEquals("jaek1997", order.getMember().getEmail());
    }

    @Test
    public void cancelOrder() {
        //given
        Member newMember = createDefaultMember();
        Store store = createDefaultStore();
        Menu menu = createDefaultMenu(store);

        int orderQuantity = 2;
        //when
        Long orderId = orderService.placeOrder(newMember.getId(), menu.getId(), store.getId(), orderQuantity);
        //then
        Order order = orderRepository.findOne(orderId);
        orderService.cancelOrder(order.getId());

        assertEquals(OrderStatus.CANCELED, order.getStatus());
    }

    private Store createDefaultStore() {
        Store store = Store.builder()
                .category("중식")
                .contact("0312221020")
                .name("옥빈관")
                .build();
        em.persist(store);
        return store;
    }

    private Member createDefaultMember() {
        Member newMember = Member.builder()
                .email("jaek1997")
                .password("123")
                .build();
        em.persist(newMember);
        return newMember;
    }

    private Menu createDefaultMenu(Store store) {
        Menu menu = Menu.createMenu(store, "메인", "짜장면", 10000, "jjajang.jpg", "맛있는 짜장면");
        em.persist(menu);
        return menu;
    }

}