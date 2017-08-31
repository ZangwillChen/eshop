package com.czw.eshop.entity;

import javax.persistence.*;

/**
 * Created by chenzhaowen on 2017/8/30.
 */

public class Goods {
    private long goodID;
    private String goodName;
    private double goodPrice;
    private String inventory;
    private String imgSrc;
    private String Description;

    public Goods() {
    }

    public Goods(String goodName) {
        this.goodName = goodName;
    }

    @Id
    @Column(name = "g_id")
    public long getGoodID() {
        return goodID;
    }

    public void setGoodID(long goodID) {
        this.goodID = goodID;
    }

    @Basic
    @Column(name = "g_name")
    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    @Basic
    @Column(name = "g_cost")
    public double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(double goodPrice) {
        this.goodPrice = goodPrice;
    }

    @Basic
    @Column(name = "g_inv")
    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    @Basic
    @Column(name = "imgsrc")
    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    @Basic
    @Column(name = "g_desc")
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (goodID != goods.goodID) return false;
        if (Double.compare(goods.goodPrice, goodPrice) != 0) return false;
        if (goodName != null ? !goodName.equals(goods.goodName) : goods.goodName != null) return false;
        if (inventory != null ? !inventory.equals(goods.inventory) : goods.inventory != null) return false;
        if (imgSrc != null ? !imgSrc.equals(goods.imgSrc) : goods.imgSrc != null) return false;
        if (Description != null ? !Description.equals(goods.Description) : goods.Description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (goodID ^ (goodID >>> 32));
        result = 31 * result + (goodName != null ? goodName.hashCode() : 0);
        temp = Double.doubleToLongBits(goodPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (inventory != null ? inventory.hashCode() : 0);
        result = 31 * result + (imgSrc != null ? imgSrc.hashCode() : 0);
        result = 31 * result + (Description != null ? Description.hashCode() : 0);
        return result;
    }
}
