package com.ujaveriana.patrones.goodsservices.service;

import com.ujaveriana.patrones.goodsservices.model.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmailService {

    private static final String URL_EMAIL = "http://localhost:8083/send_email";
    private final RestTemplate restTemplate;

    public EmailService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean sendEmail(String clientEmail, String quotationName, String supplierName){

        EmailRequest emailRequest = new EmailRequest();
        emailRequest.setEmail(clientEmail);
        emailRequest.setSubject("The quotation '" + quotationName + "' has a new offer");
        emailRequest.setMessage("The supplier '" + supplierName + "' has submitted a new offer");

        String data = restTemplate.postForObject(URL_EMAIL, emailRequest, String.class);
        return data!= null ? true: false;
    }
}
