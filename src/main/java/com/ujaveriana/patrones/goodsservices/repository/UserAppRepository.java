package com.ujaveriana.patrones.goodsservices.repository;

import com.ujaveriana.patrones.goodsservices.model.UserApp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAppRepository extends CrudRepository<UserApp, Integer> {
    UserApp findByEmail(String email);
}
