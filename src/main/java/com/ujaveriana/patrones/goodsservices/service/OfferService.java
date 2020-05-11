package com.ujaveriana.patrones.goodsservices.service;

import com.ujaveriana.patrones.goodsservices.model.Offer;
import com.ujaveriana.patrones.goodsservices.model.OfferRequest;
import com.ujaveriana.patrones.goodsservices.model.Quotation;
import com.ujaveriana.patrones.goodsservices.model.UserApp;
import com.ujaveriana.patrones.goodsservices.repository.OfferRepository;
import com.ujaveriana.patrones.goodsservices.repository.QuotationRepository;
import com.ujaveriana.patrones.goodsservices.repository.UserAppRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {


    private final EmailService emailService;
    private final OfferRepository offerRepository;
    private final QuotationRepository quotationRepository;
    private final UserAppRepository userAppRepository;

    public OfferService(EmailService emailService,
                        OfferRepository offerRepository,
                        QuotationRepository quotationRepository,
                        UserAppRepository userRepository) {
        this.emailService = emailService;
        this.offerRepository = offerRepository;
        this.quotationRepository = quotationRepository;
        this.userAppRepository = userRepository;
    }

    public Offer createOffer(OfferRequest offerRequest){
        Quotation quotation = quotationRepository.findById(offerRequest.getQuotationId()).orElse(null);
        UserApp supplier = userAppRepository.findById(offerRequest.getSupplierId()).orElse(null);

        Offer offer = new Offer();
        offer.setDecription(offerRequest.getDescription());
        offer.setPrice(offerRequest.getPrice());
        offer.setUserApp(supplier);
        offer.setQuotation(quotation);

        emailService.sendEmail(quotation.getUserApp().getEmail(), quotation.getName(), supplier.getName());

        return offerRepository.save(offer);
    }

    public List<Offer> findAll(){
        return (List<Offer>) offerRepository.findAll();
    }

    public List<Offer> filterByQuotation(Integer quotation_id){
        return (List<Offer>) offerRepository.findAllByQuotationId(quotation_id);
    }
}
