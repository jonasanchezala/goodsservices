package com.ujaveriana.patrones.goodsservices.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Quotation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    @ManyToOne
    private UserApp client;
    @OneToMany
    private Set<Offer> offers;
    @ManyToOne
    private Item item;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserApp getClient() {
        return client;
    }

    public void setClient(UserApp client) {
        this.client = client;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
