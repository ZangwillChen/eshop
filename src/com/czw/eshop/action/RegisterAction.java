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

      //  String rand = (String) request.getSession().getAttribute("rand");

        session = (Map)ActionContext.getContext().getSession();

        String ret = "";

        if (userDTO.getUserPwd1() != userDTO.getUserPwd2()){
            ret = "reset";
        }
    //    else if ((!rand.equals(userDTO.getRand()))||userDTO.getRand() == null){
      //      ret = "reset";
      //  }
        else if (userDTO.getUserName()!=null){

            user1.setUser(userDTO);
            session.put(user1.getUserName(),user1);

            ret = "verify";
        }
        else {
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
