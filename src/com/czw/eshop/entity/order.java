package com.czw.eshop.entity;

import javax.persistence.*;

/**
 * Created by chenzhaowen on 2017/8/27.
 */
@Entity
@Table(name = "tb_order", schema = "shop", catalog = "")
public class order {
    private long orderID;
    private String orderName;
    private int status;
    private user user;
    private String Item;
    private Double orderPrice;

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

    @Basic
    @Column(name = "u_id")
    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    @Basic
    @Column(name = "o_item")
    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    @Basic
    @Column(name = "cost")
    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        order order = (order) o;

        if (orderID != order.orderID) return false;
        if (status != order.status) return false;
        if (orderName != null ? !orderName.equals(order.orderName) : order.orderName != null) return false;
        if (user != null ? !user.equals(order.user) : order.user != null) return false;
        if (Item != null ? !Item.equals(order.Item) : order.Item != null) return false;
        if (orderPrice != null ? !orderPrice.equals(order.orderPrice) : order.orderPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (orderID ^ (orderID >>> 32));
        result = 31 * result + (orderName != null ? orderName.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (Item != null ? Item.hashCode() : 0);
        result = 31 * result + (orderPrice != null ? orderPrice.hashCode() : 0);
        return result;
    }
}
