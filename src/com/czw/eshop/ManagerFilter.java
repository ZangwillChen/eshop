package com.czw.eshop;

import com.czw.eshop.entity.User;
import com.czw.eshop.service.constants;
import org.apache.struts2.dispatcher.ng.filter.FilterHostConfig;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by chenzhaowen on 2017/8/26.
 */
public class ManagerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        String contextPath = request.getContextPath();

        if (session.isNew() || session.getAttribute(constants.SESSION_USER) == null){
            response.sendRedirect("http://localhost:8080/eshop/login.jsp");

            System.out.println(contextPath+"login.jsp");
            return;
        }

        else if (session.getAttribute(constants.SESSION_USER) != null){
            User u = (User) session.getAttribute(constants.SESSION_USER);

            System.out.println(u.getUserName());

        }

        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
