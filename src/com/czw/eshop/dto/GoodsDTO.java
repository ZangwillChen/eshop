package com.czw.eshop.dto;

import java.io.File;

/**
 * Created by chenzhaowen on 2017/8/29.
 */
public class GoodsDTO {

    private String name;

    private double price;

    private String description;

    private File file;

    public GoodsDTO() {
    }

    public GoodsDTO(String name, double price, String description, File file) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
