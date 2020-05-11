package com.ujaveriana.patrones.goodsservices.repository;

import com.ujaveriana.patrones.goodsservices.model.Offer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OfferRepository extends CrudRepository<Offer, Integer> {
    List<Offer> findAllByQuotationId(Integer quotation_id);
}
