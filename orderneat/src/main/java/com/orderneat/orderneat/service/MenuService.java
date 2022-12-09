package com.orderneat.orderneat.service;

import com.orderneat.orderneat.domain.Menu;
import com.orderneat.orderneat.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MenuService {

    private final MenuRepository menuRepository;

    @Transactional
    public Long saveMenu(Menu menu){
        menuRepository.save(menu);
        return menu.getId();
    }

    public List<Menu> findAllMenu(){
        return menuRepository.findAll();
    }
}
