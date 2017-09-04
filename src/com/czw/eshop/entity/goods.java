package com.czw.eshop.entity;

import com.czw.eshop.dto.GoodsDTO;

import javax.persistence.*;

/**
 * Created by chenzhaowen on 2017/8/30.
 */

public class Goods {
    private long goodID;
    private String goodName;
    private double goodPrice;
    private int inventory;
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

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
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

    public void set(GoodsDTO goodsDTO){

        this.goodName = goodsDTO.getName();
        this.goodPrice = goodsDTO.getPrice();
        this.Description = goodsDTO.getDescription();
        this.inventory = goodsDTO.getInventory();
    }

}
