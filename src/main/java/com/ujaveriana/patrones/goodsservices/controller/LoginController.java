package com.ujaveriana.patrones.goodsservices.controller;

import com.ujaveriana.patrones.goodsservices.model.Credential;
import com.ujaveriana.patrones.goodsservices.model.LoginResponse;
import com.ujaveriana.patrones.goodsservices.service.LoginService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public LoginResponse Post(@RequestBody Credential credential) {
        return loginService.validateLogin(credential);
    }
}
