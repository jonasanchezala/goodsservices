package com.ujaveriana.patrones.goodsservices.service;

import com.ujaveriana.patrones.goodsservices.model.Credential;
import com.ujaveriana.patrones.goodsservices.model.UserApp;
import com.ujaveriana.patrones.goodsservices.repository.UserAppRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginService {

    private final UserAppRepository userAppRepository;

    public LoginService(UserAppRepository userAppRepository) {
        this.userAppRepository = userAppRepository;
    }

    public boolean validateLogin(Credential credential){

        UserApp userApp = userAppRepository.findByEmail(credential.getEmail());
        boolean  validCredentials = Objects.nonNull(userApp)
                                && userApp.getPassword().equals(credential.getPassword());

        return validCredentials;
    }
}
