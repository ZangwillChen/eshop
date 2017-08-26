package com.czw.eshop.entity;

/**
 * Created by chenzhaowen on 2017/8/26.
 */
public class user {

    private long userID;
    private String userName;
    private String userPassword;
    private String userSex;
    private String userEmail;
    private long userPhone;
    private int userType;
    private String userAddr;

    public user() {
    }

    public user(long userID, String userName, String userPassword, String userSex, String userEmail, long userPhone, int userType, String userAddr) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userSex = userSex;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userType = userType;
        this.userAddr = userAddr;
    }

    public long getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserSex() {
        return userSex;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public int getUserType() {
        return userType;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }
}
