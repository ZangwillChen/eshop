package com.czw.eshop.test;

import com.czw.eshop.entity.User;
import com.czw.eshop.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chenzhaowen on 2017/9/2.
 */
public class UserTest {

    @Test
    public void login(){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-common.xml");

        UserService Service = (UserService) context.getBean("userServiceTarget");

        User user = Service.login("zangwill","123");

        System.out.println(user.getUserName());
        System.out.println(user.getUserType());
    }
}
