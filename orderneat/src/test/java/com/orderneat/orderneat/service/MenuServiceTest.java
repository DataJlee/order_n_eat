package com.orderneat.orderneat.service;

import com.orderneat.orderneat.domain.Menu;
import com.orderneat.orderneat.domain.MenuStatus;
import com.orderneat.orderneat.domain.Store;
import com.orderneat.orderneat.domain.StoreStatus;
import com.orderneat.orderneat.repository.MenuRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuServiceTest {

    @Autowired
    MenuService menuService;
    @Autowired
    MenuRepository menuRepository;

    @Test
    @Rollback(false)
    public void saveMenu() {
        //given
        Store store = new Store();
        store.setName("하남돼지집");
        store.setStatus(StoreStatus.CLOSED);
        Menu newMenu = Menu.createMenu(
                store, "메인", "삼겹살 숙주볶음", 12000, "pizza.jpg", "돼지고기 100g");
        //when
        Long savedMenu = menuService.saveMenu(newMenu);

        //then
        assertEquals(savedMenu, menuService.findAllMenu().get(0).getId());
    }
}