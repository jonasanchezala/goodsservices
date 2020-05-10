package com.ujaveriana.patrones.goodsservices.service;

import com.ujaveriana.patrones.goodsservices.model.Credential;
import com.ujaveriana.patrones.goodsservices.model.UserApp;
import com.ujaveriana.patrones.goodsservices.repository.UserAppRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserAppService {

    private final UserAppRepository userAppRepository;

    public UserAppService(UserAppRepository userAppRepository) {
        this.userAppRepository = userAppRepository;
    }

    public UserApp createUser(UserApp userApp){

        return userAppRepository.save(userApp);
    }
}
