package com.orderneat.orderneat.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrderLineTest {

    @Test
    public void createOrderLine() {
        Store store = new Store();
        store.setName("하남돼지집");
        Menu menu = Menu.createMenu(store, "메인", "쭈꾸미 볶음", 10000, "String menuImgUrl", "desc");
        //when
        OrderLine orderLine =  OrderLine.createOrderLine(menu, 10000, 2);
        //then
        assertEquals(orderLine.getMenu().getName(), "쭈꾸미 볶음");
    }

    @Test
    public void getTotalPrice() {
        Store store = new Store();
        store.setName("하남돼지집");
        Menu menu = Menu.createMenu(store, "메인", "쭈꾸미 볶음", 10000, "String menuImgUrl", "desc");
        //when
        OrderLine orderLine =  OrderLine.createOrderLine(menu, 10000, 2);
        //then
        assertEquals(20000, orderLine.getTotalPrice());
    }
}