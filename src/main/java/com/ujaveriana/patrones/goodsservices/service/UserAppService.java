package com.ujaveriana.patrones.goodsservices.service;

import com.ujaveriana.patrones.goodsservices.model.Credential;
import com.ujaveriana.patrones.goodsservices.model.UserApp;
import com.ujaveriana.patrones.goodsservices.repository.UserAppRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserAppService {

    private final UserAppRepository userAppRepository;

    public UserAppService(UserAppRepository userAppRepository) {
        this.userAppRepository = userAppRepository;
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

    public UserApp updateUser(Integer id, UserApp newUserApp) {
        UserApp userApp = userAppRepository.findById(id).orElse(null);

        if(Objects.nonNull(userApp)){
            userApp.setItems(newUserApp.getItems());
        }

        return userAppRepository.save(userApp);
    }
}
