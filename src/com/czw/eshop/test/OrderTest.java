package com.czw.eshop.test;

import com.czw.eshop.entity.Order;
import com.czw.eshop.entity.User;
import com.czw.eshop.service.UserService;
import com.czw.eshop.service.orderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chenzhaowen on 2017/9/2.
 */
public class OrderTest {

    @Test
    public void get(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-common.xml");

        orderService Service = (orderService) context.getBean("orderServiceTarget");

        Order order = Service.getOrderById((long)1);

        System.out.println(order.getStatus());

        Service.nextOrderStatus(1);

        System.out.println(order.getStatus());
    }

    @Test
    public void generate(){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-common.xml");

        orderService Service = (orderService) context.getBean("orderServiceTarget");

        UserService userService = (UserService) context.getBean("userServiceTarget");

        User user = userService.login("zang","123");

        Order order = new Order();

        order.setUser(user);

        order.setStatus(1);

        Service.generateOrder(order);
    }
}
