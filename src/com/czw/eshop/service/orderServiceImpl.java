package com.czw.eshop.service;

import com.czw.eshop.dao.BaseDao;
import com.czw.eshop.entity.order;

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
    public String generateOrder(order order) {
        if (order == null) {
            return null;
        }

        order.setOrderName(simpleDateFormat.format(new Date()));

        baseDao.saveEntity(order);

        return order.getOrderName();
    }

    @Override
    public List<order> getAllOrder() {
        return baseDao.getAllEntity("order");
    }

    @Override
    public void nextOrderStatus(long orderID) {
        order order = baseDao.getEntityById(order.class,orderID);

        if (order.getStatus() != constants.ORDER_STATUS_END){
            order.setStatus(order.getStatus()+1 );

            baseDao.updateEntity(order);
        }
    }
}
