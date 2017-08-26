package com.czw.eshop.entity;

import java.util.Date;

/**
 * Created by chenzhaowen on 2017/8/26.
 */
public class order {
    private long orderID;

    private String status;

    private user user;

    private double cost;

    public order() {
    }

    public order(long orderID, String status, com.czw.eshop.entity.user user, double cost) {
        this.orderID = orderID;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
