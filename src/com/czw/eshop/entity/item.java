package com.czw.eshop.entity;

import javax.persistence.*;

/**
 * Created by chenzhaowen on 2017/8/29.
 */

public class item {
    private long itemID;
    private int itemAmount;
    private goods goodID;
    private order orderID;

    private double cost;

    public item() {
    }

    public item(int itemAmount, goods goodID) {
        this.itemAmount = itemAmount;
        this.goodID = goodID;
    }

    @Id
    @Column(name = "i_id")
    public long getItemID() {
        return itemID;
    }

    public void setItemID(long itemID) {
        this.itemID = itemID;
    }

    @Basic
    @Column(name = "i_amount")
    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }

    @Basic
    @Column(name = "good_id")
    public goods getGoodID() {
        return goodID;
    }

    public void setGoodID(goods goodID) {
        this.goodID = goodID;
    }

    @Basic
    @Column(name = "order_id")
    public order getOrderID() {
        return orderID;
    }

    public void setOrderID(order orderID) {
        this.orderID = orderID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        item item = (item) o;

        if (itemID != item.itemID) return false;
        if (itemAmount != item.itemAmount) return false;
        if (goodID != null ? !goodID.equals(item.goodID) : item.goodID != null) return false;
        if (orderID != null ? !orderID.equals(item.orderID) : item.orderID != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (itemID ^ (itemID >>> 32));
        result = 31 * result + itemAmount;
        result = 31 * result + (goodID != null ? goodID.hashCode() : 0);
        result = 31 * result + (orderID != null ? orderID.hashCode() : 0);
        return result;
    }
}
