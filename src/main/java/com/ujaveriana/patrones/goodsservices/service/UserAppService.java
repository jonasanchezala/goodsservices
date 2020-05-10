package com.ujaveriana.patrones.goodsservices.service;

import com.ujaveriana.patrones.goodsservices.model.Item;
import com.ujaveriana.patrones.goodsservices.model.UserApp;
import com.ujaveriana.patrones.goodsservices.repository.ItemRepository;
import com.ujaveriana.patrones.goodsservices.repository.UserAppRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserAppService {

    private final UserAppRepository userAppRepository;
    private final ItemRepository itemRepository;

    public UserAppService(UserAppRepository userAppRepository,
                          ItemRepository itemRepository) {
        this.userAppRepository = userAppRepository;
        this.itemRepository = itemRepository;
    }

    public UserApp createUser(UserApp userApp){
        return userAppRepository.save(userApp);
    }

    public List<UserApp> findAll(){
        return (List<UserApp>) userAppRepository.findAll();
    }

    public UserApp findById(Integer id){
        return userAppRepository.findById(id).orElse(null);
    }

    public UserApp addItems(Integer id, List<Integer> itemsId) {
        UserApp userApp = userAppRepository.findById(id).orElse(null);

        if(Objects.nonNull(userApp)){
            Set<Item> itemSet = new HashSet<>();

            itemsId.stream().forEach(itemId -> {
                Item item = itemRepository.findById(itemId).orElse(null);
                itemSet.add(item);
            });

            userApp.setItems(itemSet);
        }

        return userAppRepository.save(userApp);
    }
}
