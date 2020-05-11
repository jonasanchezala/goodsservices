package com.ujaveriana.patrones.goodsservices.controller;

import com.ujaveriana.patrones.goodsservices.model.Offer;
import com.ujaveriana.patrones.goodsservices.model.Quotation;
import com.ujaveriana.patrones.goodsservices.model.QuotationRequest;
import com.ujaveriana.patrones.goodsservices.model.UserApp;
import com.ujaveriana.patrones.goodsservices.service.QuotationService;
import com.ujaveriana.patrones.goodsservices.service.UserAppService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quotation")
public class QuotationController {

    private final QuotationService quotationService;

    public QuotationController(QuotationService quotationService) {
        this.quotationService = quotationService;
    }

    @PostMapping
    public Quotation Post(@RequestBody QuotationRequest quotationRequest) {
        return quotationService.createQuotation(quotationRequest);
    }

    @GetMapping
    public List<Quotation> Get() {
        return quotationService.findAll();
    }

    @GetMapping("{id}")
    public Quotation getById(@PathVariable Integer id) {
        return quotationService.findById(id);
    }

    @GetMapping("getByClientId/{id}")
    public List<Quotation> getByClientId(@PathVariable Integer id) {
        return quotationService.findByClientId(id);
    }

    @GetMapping("getBySupplier/{id}")
    public List<Quotation> getBySupplier(@PathVariable Integer id) {
        return quotationService.findBySupplier(id);
    }
}
