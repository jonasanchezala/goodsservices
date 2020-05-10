package com.ujaveriana.patrones.goodsservices.controller;

import com.ujaveriana.patrones.goodsservices.model.Item;
import com.ujaveriana.patrones.goodsservices.model.UserApp;
import com.ujaveriana.patrones.goodsservices.service.ItemService;
import com.ujaveriana.patrones.goodsservices.service.UserAppService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> Get() {
        return itemService.listItems();
    }

    @PostMapping
    public Item Post(@RequestBody Item item){
        return itemService.createItem(item);
    }
}
