package com.czw.eshop.dto;

/**
 * Created by chenzhaowen on 2017/8/30.
 */
public class UserDTO {

    private String userName;
    private String userPwd1;
    private String userPwd2;
    private String userAddr;
    private String userSex;
    private String userEmail;
    private String userPhone;

    private String rand;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd1() {
        return userPwd1;
    }

    public void setUserPwd1(String userPwd1) {
        this.userPwd1 = userPwd1;
    }

    public String getUserPwd2() {
        return userPwd2;
    }

    public void setUserPwd2(String userPwd2) {
        this.userPwd2 = userPwd2;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getRand() {
        return rand;
    }

    public void setRand(String rand) {
        this.rand = rand;
    }


}
