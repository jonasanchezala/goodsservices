package com.ujaveriana.patrones.goodsservices.service;

import com.ujaveriana.patrones.goodsservices.model.Item;
import com.ujaveriana.patrones.goodsservices.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> listItems(){
        return (List<Item>) itemRepository.findAll();
    }
}
