package com.czw.eshop.action;

import com.czw.eshop.dto.UserDTO;
import com.czw.eshop.entity.user;
import com.czw.eshop.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by chenzhaowen on 2017/8/30.
 */
public class RegisterAction extends ActionSupport {

    private UserDTO userDTO = new UserDTO();

    private user user1 = new user();

    private UserService userService;

    private Map<String,Object> session;

    private HttpServletRequest request;

    private HttpServletResponse response;

    public String userRegister(){

        String rand = (String) request.getSession().getAttribute("rand");

        session = (Map)ActionContext.getContext().getSession();

        String ret = "";

        if (userDTO.getUserPwd1() != userDTO.getUserPwd2()){
            ret = "reset";
        }
        else if ((!rand.equals(userDTO.getRand()))||userDTO.getRand() == null){
            ret = "reset";
        }
        else if (userDTO.getUserName()!=null){

            user1
        }
    }
}
