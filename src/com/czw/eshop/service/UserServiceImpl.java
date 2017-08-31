package com.czw.eshop.service;

import com.czw.eshop.dao.UserDao;
import com.czw.eshop.dao.UserDaoImpl;
import com.czw.eshop.entity.User;

/**
 * Created by chenzhaowen on 2017/8/26.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    @Override
    public User login(String userName, String userPassword) {
        return userDao.loginCheck(userName, userPassword);
    }

    @Override
    public void add(User user) {
        this.userDao.save(user);
    }
}




