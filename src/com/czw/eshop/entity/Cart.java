package com.czw.eshop.entity;


import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenzhaowen on 2017/8/29.
 */
public class Cart {

    private Logger logger = Logger.getLogger(this.getClass());

    private Map<Long,OrderItem> items = new HashMap<>();

    //添加商品到购物车
    public void addItem(Goods good , int number){
        if (items.containsKey(good.getGoodID())){
            return;
        }
        OrderItem itemSelected = new OrderItem(number,good);

        items.put(good.getGoodID(),itemSelected);

        //int Inv = good.getInventory();

        //Inv = Inv - 1;

       // good.setInventory(Inv);
    }

    //修改商品数量
    public void changeNumberOfGoods(long goodID , int number){
        OrderItem item = items.get(goodID);

        item.setItemAmount(number);
    }

    public void deleteItemById(Long[] goodID){
        items.remove(goodID);
    }

    public void clearCart(){
        items.clear();

        logger.info("购物车清空:"+items.size());
    }

    public Map<Long,OrderItem> getCartItems(){
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

            OrderItem priceToCal = items.get(id);

            totalPrice += priceToCal.getCost();
        }
        return totalPrice;
    }

    public Map<Long,OrderItem> getItems(){
        return items;
    }

    public void setItems(Map<Long,OrderItem> items){
        this.items = items;
    }

}
