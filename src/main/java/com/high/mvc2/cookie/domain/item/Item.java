package com.high.mvc2.cookie.domain.item;

import lombok.Data;

@Data
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(Long id, Integer price, Integer quantity) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }
}
