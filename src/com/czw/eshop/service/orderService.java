package com.czw.eshop.service;

import com.czw.eshop.entity.Order;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/8/26.
 */
public interface orderService {

    public String generateOrder(Order order);

    public List<Order> getAllOrder();

    public Order getOrderById(long orderID);

    public void nextOrderStatus(long orderID);
}
