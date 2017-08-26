package com.czw.eshop.service;

import com.czw.eshop.entity.user;

/**
 * Created by chenzhaowen on 2017/8/26.
 */
public interface UserService {

    public user login(String userName, String userPassword);

    public void add(user user);
}
