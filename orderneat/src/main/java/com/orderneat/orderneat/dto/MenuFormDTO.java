package com.orderneat.orderneat.dto;

import com.orderneat.orderneat.domain.MenuStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MenuFormDTO {

    private Long id;

    private String category;

    private String name;

    private String desc;

    private int price;

    private MenuStatus status;

    private String imgUrl;
}
