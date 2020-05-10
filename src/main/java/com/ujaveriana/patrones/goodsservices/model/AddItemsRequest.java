package com.ujaveriana.patrones.goodsservices.model;

import java.util.List;

public class AddItemsRequest {
    private List<Integer> itemsId;

    public List<Integer> getItemsId() {
        return itemsId;
    }

    public void setItemsId(List<Integer> itemsId) {
        this.itemsId = itemsId;
    }
}
