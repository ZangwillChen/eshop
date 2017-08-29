package com.czw.eshop.entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenzhaowen on 2017/8/29.
 */
public class order {
    private long orderID;
    private String orderName;
    private int status;
    private user user;
    private Double orderPrice;
    private Map<Long,item> items = new HashMap<Long,item>();

    public order() {
        super();
    }

    public order(int status, com.czw.eshop.entity.user user) {
        super();
        this.status = status;
        this.user = user;
    }

    @Id
    @Column(name = "o_id")
    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    @Basic
    @Column(name = "orderName")
    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Basic
    @Column(name = "o_status")
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

    @Basic
    @Column(name = "cost")
    public Double getOrderPrice() {
        double sum = 0;
        for (long id : items.keySet()){
            item i = items.get(id);

            sum += i.getCost();
         }
         this.orderPrice = sum;
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }



    public Map<Long, item> getItems() {
        return items;
    }

    public void setItems(Map<Long, item> items) {
        this.items = items;
    }
}
