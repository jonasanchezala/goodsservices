package com.ujaveriana.patrones.goodsservices.controller;

import com.ujaveriana.patrones.goodsservices.model.AddItemsRequest;
import com.ujaveriana.patrones.goodsservices.model.UserApp;
import com.ujaveriana.patrones.goodsservices.service.UserAppService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserAppController {

    private final UserAppService userAppService;

    public UserAppController(UserAppService userAppService) {
        this.userAppService = userAppService;
    }

    @PostMapping
    public UserApp Post(@RequestBody UserApp userApp) {
        return userAppService.createUser(userApp);
    }

    @GetMapping
    public List<UserApp> Get() {
        return userAppService.findAll();
    }

    @GetMapping("{id}")
    public UserApp GetById(@PathVariable Integer id) {
        return userAppService.findById(id);
    }

    @PutMapping("{id}")
    public UserApp addItems(@RequestBody AddItemsRequest addItemsRequest, @PathVariable Integer id) {
        return userAppService.addItems(id, addItemsRequest.getItemsId());
    }
}
