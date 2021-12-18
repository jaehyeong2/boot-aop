package com.high.mvc2.cookie.domain.item;


import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository
public class ItemRepository {

    private static final Map<Long,Item> store = new HashMap<>();
}
