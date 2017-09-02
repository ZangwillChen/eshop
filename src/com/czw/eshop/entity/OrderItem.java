package com.czw.eshop.entity;

import javax.persistence.*;

/**
 * Created by chenzhaowen on 2017/8/30.
 */

public class OrderItem {
    private long itemID;
    private int itemAmount;
    private Goods goodID;
    private Order orderID;

    private double cost;

    public OrderItem() {
        super();
    }

    public OrderItem(int itemAmount, Goods goodID) {
        super();
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

    public Goods getGoodID() {
        return goodID;
    }

    public double getCost() {
        return (goodID.getGoodPrice()*itemAmount);
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setGoodID(Goods goodID) {
        this.goodID = goodID;
    }

    public Order getOrderID() {
        return orderID;
    }

    public void setOrderID(Order orderID) {
        this.orderID = orderID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        if (itemID != orderItem.itemID) return false;
        if (itemAmount != orderItem.itemAmount) return false;
        if (goodID != null ? !goodID.equals(orderItem.goodID) : orderItem.goodID != null) return false;
        if (orderID != null ? !orderID.equals(orderItem.orderID) : orderItem.orderID != null) return false;

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
