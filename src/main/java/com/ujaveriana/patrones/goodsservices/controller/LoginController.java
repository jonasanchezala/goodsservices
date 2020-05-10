package com.ujaveriana.patrones.goodsservices.controller;

import com.ujaveriana.patrones.goodsservices.model.Credential;
import com.ujaveriana.patrones.goodsservices.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public boolean Post(@RequestBody Credential credential) {
        return loginService.validateLogin(credential);
    }
}
