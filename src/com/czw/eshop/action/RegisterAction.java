package com.czw.eshop.action;

import com.czw.eshop.dto.UserDTO;
import com.czw.eshop.entity.User;
import com.czw.eshop.service.UserService;
import com.czw.eshop.util.ProductCode;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by chenzhaowen on 2017/8/30.
 */
public class RegisterAction extends ActionSupport implements ModelDriven{

    private UserDTO userDTO = new UserDTO();

    private User user1 = new User();

    private String username;

    private UserService userService;

    private Map<String,Object> session;

    private HttpServletRequest request;

    private HttpServletResponse response;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Object getModel() {
        return userDTO;
    }

    public String userRegister(){

        session = (Map)ActionContext.getContext().getSession();

        String rand = (String) request.getSession().getAttribute("rand");

        System.out.println("验证码"+rand);

        String ret = "";

        if (!userDTO.getUserPwd1().equals(userDTO.getUserPwd2())){

            System.out.println("密码错误");

            ret = "reset";
        }
        else if ((!rand.equals(userDTO.getRand())) || userDTO.getRand() == null){
            System.out.println("验证码错误");
            ret = "reset";
        }
        else if (userDTO.getUserName()!=null){

            user1.set(userDTO);

            userService.add(user1);

          //  session.put(user1.getUserName(),user1);

            ret = "verify";
        }
        else {
            System.out.println("神秘错误");
            ret = "reset";
        }
        return ret;
    }

    public String userSave(){

        session = (Map)ActionContext.getContext().getSession();

        User u = (User) session.get(username);

        userService.add(u);

        return "save";

     }

     public void code(){
        request = ServletActionContext.getRequest();

        response = ServletActionContext.getResponse();

         ProductCode.productCode(request,response);
     }
}
