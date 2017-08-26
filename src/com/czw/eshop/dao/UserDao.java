package com.czw.eshop.dao;

import com.czw.eshop.entity.user;

/**
 * Created by chenzhaowen on 2017/8/26.
 */
public interface UserDao extends BaseDao {

    public user loginCheck(String userName,String userPassword);

    public void save(user user);
}
