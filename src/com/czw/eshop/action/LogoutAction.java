package com.czw.eshop.action;

import com.czw.eshop.entity.User;
import com.czw.eshop.service.constants;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by chenzhaowen on 2017/8/30.
 */
public class LogoutAction extends ActionSupport {

    private HttpServletRequest request;

    private HttpSession session;

    private ServletContext context;

    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    public String execute() throws Exception {

        this.request = ServletActionContext.getRequest();

        this.session = this.request.getSession();

        User user1 = (User) this.session.getAttribute(constants.SESSION_USER);

        logger.info(user1.getUserName()+" 已登出");

       // this.session.removeAttribute(constants.SESSION_USER);

        this.session.invalidate();

        return "out";

    }
}
