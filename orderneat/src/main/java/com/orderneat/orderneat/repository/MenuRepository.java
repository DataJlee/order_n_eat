package com.orderneat.orderneat.repository;

import com.orderneat.orderneat.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MenuRepository extends JpaRepository<Menu, Long> {
}
