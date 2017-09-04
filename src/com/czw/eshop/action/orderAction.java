package com.czw.eshop.action;

import com.czw.eshop.entity.Cart;
import com.czw.eshop.entity.Goods;
import com.czw.eshop.entity.Order;
import com.czw.eshop.entity.User;
import com.czw.eshop.service.constants;
import com.czw.eshop.service.goodsService;
import com.czw.eshop.service.orderService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by chenzhaowen on 2017/8/26.
 */
public class orderAction extends ActionSupport {

    private goodsService goodsservice;

    private orderService orderservice;

    private long goodID;

    private HttpServletRequest request ;

    private HttpSession session ;



    public goodsService getGoodsservice() {
        return goodsservice;
    }

    public void setGoodsservice(goodsService goodsservice) {
        this.goodsservice = goodsservice;
    }

    public long getGoodID() {
        return goodID;
    }

    public void setGoodID(long goodID) {
        this.goodID = goodID;
    }

    public orderService getOrderservice() {
        return orderservice;
    }

    public void setOrderservice(orderService orderservice) {
        this.orderservice = orderservice;
    }

    public String index(){
        String ret = "";

        this.request = ServletActionContext.getRequest();

        this.session = this.request.getSession();

        User u = (User) this.session.getAttribute(constants.SESSION_USER);

        if (u == null){
            ret = "login";
        }
        else {
            ret = "order";
        }

        return ret;
    }


    public String postOrder( ){


        this.request = ServletActionContext.getRequest();

        this.session = this.request.getSession();

        User u = (User) this.session.getAttribute(constants.SESSION_USER);

        Cart cart = (Cart) this.session.getAttribute(constants.SESSION_CART);

        Order o = new Order();

        o.setUser(u);

        o.setItems(cart.getItems());

        o.setStatus(constants.ORDER_STATUS_POST);

        String orderNum = orderservice.generateOrder(o);

        this.request.setAttribute(constants.REQ_ORDER_NUMBER,orderNum);

        return "success";
    }
}
