package com.czw.eshop.entity;


import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenzhaowen on 2017/8/29.
 */
public class Cart {

    private Logger logger = Logger.getLogger(this.getClass());

    private Map<Long,item> items = new HashMap<>();

    //添加商品到购物车
    public void addItem(goods good , int number){
        if (items.containsKey(good.getGoodID())){
            return;
        }
        item itemSelected = new item(number,good);

        items.put(good.getGoodID(),itemSelected);
    }

    //修改商品数量
    public void changeNumberOfGoods(long goodID , int number){
        item item = items.get(goodID);

        item.setItemAmount(number);
    }

    public void clearCart(){
        items.clear();

        logger.info("购物车清空:"+items.size());
    }

    public Map<Long,item> getCartItems(){
        return items;
    }

    public int getItemNumber(){
        return items.size();
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public Double getPrice(){
        double totalPrice = 0;

        for (Long id : items.keySet()){

            item priceToCal = items.get(id);

            totalPrice += priceToCal.getCost();
        }
        return totalPrice;
    }

    public Map<Long,item> getItems(){
        return items;
    }

    public void setItems(Map<Long,item> items){
        this.items = items;
    }

}
