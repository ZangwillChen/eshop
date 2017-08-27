package com.czw.eshop.dao;

import com.czw.eshop.entity.user;
import org.hibernate.Session;

import java.util.List;
import java.io.Serializable;

/**
 * Created by chenzhaowen on 2017/8/26.
 */
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    @Override
    public user loginCheck(String userName, String userPassword){

        String hql = "from com.czw.eshop.entity.user u where u.userName = "+"'"+userName +"'" + " " + "and u.userPassword =" + " " + "'"+userPassword +"'";

        List<user> list = this.getHibernateTemplate().find(hql);

        if (list != null && list.size() > 0){
            System.out.println("用户登录，用户名："+list.get(0).getUserName());
            return list.get(0);
        }

        else {
            return null;
        }

    }

    @Override
    public void save(user user) {

        super.saveEntity(user);
    }
}
