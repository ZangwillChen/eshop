package com.czw.eshop.dao;

import com.czw.eshop.entity.User;

/**
 * Created by chenzhaowen on 2017/8/26.
 */
public interface UserDao extends BaseDao {

    public User loginCheck(String userName,String userPassword);

    public void save(User user);
}
