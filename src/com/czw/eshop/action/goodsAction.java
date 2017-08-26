package com.czw.eshop.action;

import com.czw.eshop.entity.goods;
import com.czw.eshop.service.goodsService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by chenzhaowen on 2017/8/26.
 */
public class goodsAction extends ActionSupport  {

    private goodsService goodsservice;

    private goods good;

    private List<goods> goodsList;

    private HttpServletRequest request;

    private HttpServletResponse response;

    //添加分页

    private int page;

    private int maxpage;

    private long goodID;

    public goodsService getGoodsservice() {
        return goodsservice;
    }

    public void setGoodsservice(goodsService goodsservice) {
        this.goodsservice = goodsservice;
    }

    public List<goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<goods> goodsList) {
        this.goodsList = goodsList;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getMaxpage() {
        return maxpage;
    }

    public void setMaxpage(int maxpage) {
        this.maxpage = maxpage;
    }

    public long getGoodID() {
        return goodID;
    }

    public void setGoodID(long goodID) {
        this.goodID = goodID;
    }

    public String goodslist(){
        this.request = ServletActionContext.getRequest();

        int maxpage = this.goodsservice.maxsize();

        int pageNo  =1;

        int pageSize = 5;

        if( page >  0 )
        {
            pageNo = page;
        }

        goodsList = this.goodsservice.getByPage(pageNo,pageSize);

        request.setAttribute("page",pageNo);

        request.setAttribute("maxpage",maxpage);

        return "list";
    }

}
