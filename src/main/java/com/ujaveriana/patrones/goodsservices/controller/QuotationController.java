package com.ujaveriana.patrones.goodsservices.controller;

import com.ujaveriana.patrones.goodsservices.model.Quotation;
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
    public Quotation Post(@RequestBody Quotation quotation) {
        return quotationService.createQuotation(quotation);
    }

    @GetMapping
    public List<Quotation> Get() {
        return quotationService.findAll();
    }

    @GetMapping("{id}")
    public Quotation GetById(@PathVariable Integer id) {
        return quotationService.findById(id);
    }

    @PutMapping("{id}")
    public Quotation Put(@RequestBody Quotation newQuotation, @PathVariable Integer id) {
        return quotationService.updateQuotation(id, newQuotation);
    }
}
