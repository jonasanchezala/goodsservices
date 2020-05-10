package com.ujaveriana.patrones.goodsservices.model;

import javax.persistence.*;

@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String decription;
    private Double price;
    @ManyToOne
    private UserApp supplier;
    @ManyToOne
    private Quotation quotation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public UserApp getSupplier() {
        return supplier;
    }

    public void setSupplier(UserApp supplier) {
        this.supplier = supplier;
    }

    public Quotation getQuotation() {
        return quotation;
    }

    public void setQuotation(Quotation quotation) {
        this.quotation = quotation;
    }
}
