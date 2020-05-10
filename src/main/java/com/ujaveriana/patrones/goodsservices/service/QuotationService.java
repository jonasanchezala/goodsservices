package com.ujaveriana.patrones.goodsservices.service;

import com.ujaveriana.patrones.goodsservices.model.Credential;
import com.ujaveriana.patrones.goodsservices.model.Offer;
import com.ujaveriana.patrones.goodsservices.model.Quotation;
import com.ujaveriana.patrones.goodsservices.model.UserApp;
import com.ujaveriana.patrones.goodsservices.repository.QuotationRepository;
import com.ujaveriana.patrones.goodsservices.repository.UserAppRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class QuotationService {

    private final QuotationRepository quotationRepository;

    public QuotationService(QuotationRepository quotationRepository) {
        this.quotationRepository = quotationRepository;
    }

    public Quotation createQuotation(Quotation quotation){
        return quotationRepository.save(quotation);
    }

    public List<Quotation> findAll(){
        return (List<Quotation>) quotationRepository.findAll();
    }

    public Quotation findById(Integer id){
        return quotationRepository.findById(id).orElse(null);
    }

    public Quotation updateQuotation(Integer id, Quotation newQuotation) {
        Quotation quotation = quotationRepository.findById(id).orElse(null);

        if(Objects.nonNull(quotation)){
            Offer offer = newQuotation.getOffers().stream().findFirst().orElse(null);

            quotation.getOffers().add(offer);
        }

        return quotationRepository.save(quotation);
    }
}
