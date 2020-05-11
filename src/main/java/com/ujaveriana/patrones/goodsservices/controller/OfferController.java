package com.ujaveriana.patrones.goodsservices.controller;

import com.ujaveriana.patrones.goodsservices.model.Offer;
import com.ujaveriana.patrones.goodsservices.model.OfferRequest;
import com.ujaveriana.patrones.goodsservices.service.OfferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OfferController {
    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping
    public Offer Post(@RequestBody OfferRequest offerRequest){
        return offerService.createOffer(offerRequest);
    }

    @GetMapping
    public List<Offer> Get(){
        return offerService.findAll();
    }

    @GetMapping("{quotation_id}")
    public List<Offer> Get(@PathVariable Integer quotation_id){
        return offerService.filterByQuotation(quotation_id);
    }
}
