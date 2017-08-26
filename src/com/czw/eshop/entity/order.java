package com.czw.eshop.entity;

import java.util.Date;

/**
 * Created by chenzhaowen on 2017/8/26.
 */
public class order {
    private long orderID;

    private String orderName;

    private int status;

    private user user;

    private double cost;

    private long item ;

    public order() {
    }

    public long getItem() {
        return item;
    }

    public void setItem(long item) {
        this.item = item;
    }

    public order(long orderID, String orderName, int status, com.czw.eshop.entity.user user, double cost , long item)  {
        this.orderID = orderID;
        this.orderName = orderName;
        this.status = status;
        this.user = user;
        this.cost = cost;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public com.czw.eshop.entity.user getUser() {
        return user;
    }

    public void setUser(com.czw.eshop.entity.user user) {
        this.user = user;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
