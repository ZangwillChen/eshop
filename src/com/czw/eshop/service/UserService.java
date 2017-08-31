package com.czw.eshop.service;

import com.czw.eshop.entity.User;

/**
 * Created by chenzhaowen on 2017/8/26.
 */
public interface UserService {

    public User login(String userName, String userPassword);

    public void add(User user);
}
