package com.czw.eshop.service;

import com.czw.eshop.dao.BaseDao;
import com.czw.eshop.entity.Order;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by chenzhaowen on 2017/8/26.
 */
public class orderServiceImpl implements orderService {

    private BaseDao baseDao;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    public BaseDao getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public String generateOrder(Order order) {
        if (order == null) {
            return null;
        }

        order.setOrderName(simpleDateFormat.format(new Date()));

        baseDao.saveEntity(order);

        return order.getOrderName();
    }

    @Override
    public List<Order> getAllOrder() {
        return baseDao.getAllEntity("Order");
    }

    @Override
    public Order getOrderById(long orderID) {
        return baseDao.getEntityById(Order.class,orderID);
    }

    @Override
    public void nextOrderStatus(long orderID) {
        Order order = baseDao.getEntityById(Order.class,orderID);

        if (order.getStatus() != constants.ORDER_STATUS_END){
            order.setStatus(order.getStatus()+1 );

            baseDao.updateEntity(order);
        }
    }
}
