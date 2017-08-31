package com.czw.eshop.action;

import com.czw.eshop.entity.Cart;
import com.czw.eshop.entity.OrderItem;
import com.czw.eshop.service.constants;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by chenzhaowen on 2017/8/30.
 */
public class CartAction extends ActionSupport {

    private Logger logger = Logger.getLogger(this.getClass());

    private HttpServletResponse response;

    private HttpServletRequest request;

    private HttpSession session;

    public String CartIndex(){

        this.request = ServletActionContext.getRequest();

        this.session = this.request.getSession();

        Cart cart = (Cart) this.session.getAttribute(constants.SESSION_CART);

        if (cart == null){
            cart = new Cart();

            this.session.setAttribute(constants.SESSION_CART,cart);
        }

        return "cart";
    }

    public String modifyItemNumber(){

        this.request = ServletActionContext.getRequest();

        this.session = this.request.getSession();

        String [] itemCheck = this.request.getParameterValues("itemCheck");

        if (itemCheck == null || itemCheck.length == 0){
            return "cart";
        }
        else {
            Cart cart = (Cart) this.session.getAttribute(constants.SESSION_CART);

            for (String goodID : itemCheck){
                String number = this.request.getParameter("number"+goodID);

                cart.changeNumberOfGoods(Long.valueOf(goodID),Integer.valueOf(number));
            }

            for (Long id : cart.getCartItems().keySet()){

                OrderItem item = cart.getItems().get(id);

                logger.info(item.getGoodID().getGoodName()+"，数量："+item.getItemAmount());
            }

        }
        return "cart";
    }

    public String deleteItem() {

        this.request = ServletActionContext.getRequest();

        this.session = this.request.getSession();

        String [] itemCheck = this.request.getParameterValues("itemCheck");

        if (itemCheck == null || itemCheck.length == 0){
            return "cart";
        }
        else {

            logger.info("删除物品数量:"+itemCheck.length);

            Long [] goodID = new Long[itemCheck.length];

            Cart cart = (Cart) this.session.getAttribute(constants.SESSION_CART);

            for (int i = 0;i < itemCheck.length ; i++ ){
                goodID[i] = Long.valueOf(itemCheck[i]);
            }

            cart.deleteItemById(goodID);

            for (Long id : cart.getCartItems().keySet()){

                OrderItem item = cart.getItems().get(id);

                logger.info(item.getGoodID().getGoodName()+"，数量："+item.getItemAmount());
            }

        }
        return "cart";
    }

    public String clear(){

        this.request = ServletActionContext.getRequest();

        this.session = this.request.getSession();

        logger.info("清除购物车");

        Cart cart = (Cart) this.session.getAttribute(constants.SESSION_CART);

        cart.clearCart();

        for (Long id : cart.getCartItems().keySet()){

            OrderItem item = cart.getItems().get(id);

            logger.info(item.getGoodID().getGoodName()+"，数量："+item.getItemAmount());
        }

        return "cart";
    }
}
