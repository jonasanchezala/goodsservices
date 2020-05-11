package com.ujaveriana.patrones.goodsservices.repository;

import com.ujaveriana.patrones.goodsservices.model.Quotation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuotationRepository extends CrudRepository<Quotation, Integer> {
    List<Quotation> findAllByUserAppId(Integer userappid);
    List<Quotation> findAllByItemId(Integer itemId);
}
