package com.ujaveriana.patrones.goodsservices.repository;

import com.ujaveriana.patrones.goodsservices.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
}
