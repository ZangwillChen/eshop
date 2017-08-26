package com.czw.eshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * Created by chenzhaowen on 2017/8/26.
 */
public class goods {

    private long goodID;
    private String goodName;
    private double goodPrice;
    private int inventory;

    public goods() {
    }

    public goods(long goodID, String goodName, double goodPrice, int inventory) {
        this.goodID = goodID;
        this.goodName = goodName;
        this.goodPrice = goodPrice;
        this.inventory = inventory;
    }

    public long getGoodID() {
        return goodID;
    }

    public void setGoodID(long goodID) {
        this.goodID = goodID;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
