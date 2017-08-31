package com.czw.eshop.dao;

import com.czw.eshop.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import java.util.List;
import java.io.Serializable;

/**
 * Created by chenzhaowen on 2017/8/26.
 */
public class UserDaoImpl extends BaseDaoImpl implements UserDao {


    @Override
    public User loginCheck(String userName, String userPassword) {

        String hql = "from User user where user.userName ="+"'"+userName+"'"+"and user.userPwd = "+"'"+userPassword+"'";

        List<User> userList = this.getHibernateTemplate().find(hql);

        if (userList != null && userList.size() > 0){
            super.logger.info("login check succ, user.name=" + userList.get(0).getUserName());

            return userList.get(0);
        }

        else {
            return null;
        }
    }

    @Override
    public void save(User user) {

        super.saveEntity(user);
    }
}
