package com.ujaveriana.patrones.goodsservices.model;

public class OfferRequest {
    private Double price;
    private String description;
    private int quotationId;
    private int supplierId;

    public int getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(int quotationId) {
        this.quotationId = quotationId;
    }

    public Double getPrice(){
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
}
