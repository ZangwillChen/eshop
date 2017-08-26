package com.czw.eshop.service;

import com.czw.eshop.entity.order;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/8/26.
 */
public interface orderService {

    public String generateOrder(order order);

    public List<order> getAllOrder();

    public void nextOrderStatus(long orderID);
}
