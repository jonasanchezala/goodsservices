package com.ujaveriana.patrones.goodsservices.service;

import com.ujaveriana.patrones.goodsservices.model.*;
import com.ujaveriana.patrones.goodsservices.repository.ItemRepository;
import com.ujaveriana.patrones.goodsservices.repository.QuotationRepository;
import com.ujaveriana.patrones.goodsservices.repository.UserAppRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class QuotationService {

    private final QuotationRepository quotationRepository;
    private final UserAppRepository userAppRepository;
    private final ItemRepository itemRepository;

    public QuotationService(QuotationRepository quotationRepository,
                            UserAppRepository userAppRepository,
                            ItemRepository itemRepository) {
        this.quotationRepository = quotationRepository;
        this.userAppRepository = userAppRepository;
        this.itemRepository = itemRepository;
    }

    public Quotation createQuotation(QuotationRequest quotationRequest){
        UserApp userApp = userAppRepository.findById(quotationRequest.getClientId()).orElse(null);
        Item item = itemRepository.findById(quotationRequest.getItemId()).orElse(null);

        Quotation quotation = new Quotation();
        quotation.setName(quotationRequest.getName());
        quotation.setDescription(quotationRequest.getDescription());
        quotation.setClient(userApp);
        quotation.setItem(item);

        return quotationRepository.save(quotation);
    }

    public List<Quotation> findAll(){
        return (List<Quotation>) quotationRepository.findAll();
    }

    public Quotation findById(Integer id){
        return quotationRepository.findById(id).orElse(null);
    }

    public Quotation addOffer(Integer id, Offer offer) {
        Quotation quotation = quotationRepository.findById(id).orElse(null);

        if(Objects.nonNull(quotation)){
            quotation.getOffers().add(offer);
        }

        return quotationRepository.save(quotation);
    }
}
