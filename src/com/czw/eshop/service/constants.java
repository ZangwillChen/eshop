package com.czw.eshop.service;

/**
 * Created by chenzhaowen on 2017/8/26.
 */
public class constants {

    //order status
    public static final int ORDER_STATUS_POST = 1; 			//订单已经提交
    public static final int ORDER_STATUS_SEND = 2;			//已发货
    public static final int ORDER_STATUS_RECEIVE = 3;		//用户已经收货
    public static final int ORDER_STATUS_END = 4;			//订单结束

    //session attribute name
    public static final String SESSION_USER = "user";		//保存在Session里面的购物车
    public static final String SESSION_CART = "cart";

    //request attribute name
    public static final String REQ_GOODS = "goods";	//请求里面的所有商品
    public static final String REQ_ORDER_NUMBER = "orderNum";//请求里面的订单号
    public static final String REQ_ORDERS = "orders";		//请求里面的所有订单

    public static  String  OrderStatus( int status ) {

        String text = null;

        switch( status )
        {

            case constants.ORDER_STATUS_POST:

                text="订单已提交";

                break;
            case constants.ORDER_STATUS_SEND:

                text="已发货";

                break;

            case  constants.ORDER_STATUS_RECEIVE:

                text="用户已收货";

                break;

            case  constants.ORDER_STATUS_END:

                text="订单完成";

                break;
            default:

                break;

        }


        return text;
    }
}
