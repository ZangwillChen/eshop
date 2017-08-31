package com.czw.eshop.action;

import com.czw.eshop.entity.Order;
import com.czw.eshop.service.orderService;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/8/30.
 */
public class ManageAction extends ActionSupport {

    private orderService orderService;

    private List<Order> orders;

    private long orderID;

    private String msg;

    public com.czw.eshop.service.orderService getOrderService() {
        return orderService;
    }

    public void setOrderService(com.czw.eshop.service.orderService orderService) {
        this.orderService = orderService;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String index(){

        orders = orderService.getAllOrder();

        for (Order o : orders){
            System.out.println(o.getOrderPrice());
        }
        return "manager";
    }

    public String next(){
        orderService.nextOrderStatus(orderID);
        return "next";
    }

}
