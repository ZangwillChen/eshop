package com.czw.eshop.action;

import com.czw.eshop.entity.goods;
import com.czw.eshop.service.UserService;
import com.czw.eshop.service.goodsService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by chenzhaowen on 2017/8/26.
 */
public class ListAction extends ActionSupport {

    private goodsService goodsService;

    private List<goods> goodsList;

    private long goodID;

    private UserService userservice;

    private UserService userService;

    private HttpServletRequest request;

    private HttpServletResponse response;

    private HttpSession session;

    private ServletContext application;

    private int page;

    private int maxpage;


    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public com.czw.eshop.service.goodsService getGoodsService() {
        return goodsService;
    }

    public void setGoodsService(com.czw.eshop.service.goodsService goodsService) {
        this.goodsService = goodsService;
    }

    public List<goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<goods> goodsList) {
        this.goodsList = goodsList;
    }

    public long getGoodID() {
        return goodID;
    }

    public void setGoodID(long goodID) {
        this.goodID = goodID;
    }

    public String list(){
        this.request = ServletActionContext.getRequest();
        int maxpage = goodsService.maxsize();

        int pageNo  =1;

        int pageSize = 5;

        if( page >  0 )
        {
            pageNo = page;
        }

        goodsList = this.goodsService.getByPage(pageNo,pageSize);

        request.setAttribute("page",pageNo);

        request.setAttribute("maxpage",maxpage);

        return "list";
    }
}
