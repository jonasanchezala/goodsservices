package com.ujaveriana.patrones.goodsservices.controller;

import com.ujaveriana.patrones.goodsservices.model.UserApp;
import com.ujaveriana.patrones.goodsservices.service.UserAppService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public UserApp Put(@RequestBody UserApp newUserApp, @PathVariable Integer id) {
        return userAppService.updateUser(id, newUserApp);
    }
}
