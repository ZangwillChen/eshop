package com.czw.eshop.action;

import com.czw.eshop.service.constants;
import com.opensymphony.xwork2.ActionSupport;

import com.czw.eshop.entity.user;
import com.czw.eshop.service.UserService;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by chenzhaowen on 2017/8/26.
 */
@Scope("prototype")
@Controller("loginAction")
public class LoginAction extends ActionSupport {

    private String username;

    private String password;

    private UserService userService;

    private HttpServletRequest request;

    private HttpSession session;

    private ServletContext application;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute() throws Exception {
        this.request = ServletActionContext.getRequest();

        this.session = this.request.getSession();

        String ret = "";

        user user = this.userService.login(username,password);

        if (user == null){
            this.request.setAttribute("msg","用户名或密码错误,登录失败");

            ret = "restart";
        }

        else {
            this.session.setAttribute(constants.SESSION_USER,user);
        }
        return ret;
    }

}
