package com.orderneat.orderneat.service;

import com.orderneat.orderneat.domain.*;
import com.orderneat.orderneat.repository.MemberRepository;
import com.orderneat.orderneat.repository.MenuRepository;
import com.orderneat.orderneat.repository.OrderRepository;
import com.orderneat.orderneat.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final MenuRepository menuRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public Long order(Long memberId, Long menuId, Long storeId, int quantity){

        Member member = memberRepository.findOne(memberId);
        Menu menu = menuRepository.findOne(menuId);
        Store store = storeRepository.findOne(storeId);

        OrderLine orderLine = OrderLine.createOrderLine(menu, menu.getPrice(), quantity);

        Order order = Order.createOrder(member, store, orderLine);

        orderRepository.save(order);

        return order.getId();
    }

    @Transactional
    public void cancelOrder(Long orderId){

        Order order = orderRepository.findOne(orderId);
        order.cancelOrder();
    }


}
