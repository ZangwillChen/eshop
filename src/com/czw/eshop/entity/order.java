package com.czw.eshop.entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenzhaowen on 2017/8/30.
 */

public class Order {
    private long orderID;
    private String orderName;
    private int status;
    private User user;
    private Double orderPrice;
    private Map<Long,OrderItem> items = new HashMap<Long,OrderItem>();

    public Order() {
        super();
    }

    public Order(int status, User user) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Basic
    @Column(name = "cost")
    public Double getOrderPrice() {
        double sum = 0;
        for (long id : items.keySet()){
            OrderItem i = items.get(id);

            sum += i.getCost();
        }
        this.orderPrice = sum;

        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderID != order.orderID) return false;
        if (status != order.status) return false;
        if (orderName != null ? !orderName.equals(order.orderName) : order.orderName != null) return false;
        if (user != null ? !user.equals(order.user) : order.user != null) return false;
        if (orderPrice != null ? !orderPrice.equals(order.orderPrice) : order.orderPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (orderID ^ (orderID >>> 32));
        result = 31 * result + (orderName != null ? orderName.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (orderPrice != null ? orderPrice.hashCode() : 0);
        return result;
    }

    public Map<Long, OrderItem> getItems() {
        return items;
    }

    public void setItems(Map<Long, OrderItem> items) {
        this.items = items;
    }
}
