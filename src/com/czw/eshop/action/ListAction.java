package com.czw.eshop.action;

import com.czw.eshop.entity.Cart;
import com.czw.eshop.entity.Goods;
import com.czw.eshop.entity.User;
import com.czw.eshop.service.UserService;
import com.czw.eshop.service.constants;
import com.czw.eshop.service.goodsService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
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

    Logger logger = Logger.getLogger(this.getClass());

    private goodsService goodsService;

    private List<Goods> goodsList;

    private long goodID;

    private UserService userservice;

    private UserService userService;

    private HttpServletRequest request;

    private HttpServletResponse response;

    private HttpSession session;

    private ServletContext application;

    private int page;

    private int maxpage;

    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

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

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
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

    public String userlist(){
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

    public String addItem(){

        this.request = ServletActionContext.getRequest();

        this.session = this.request.getSession();

        String ret = "add";

        System.out.println(goodID);

        Goods goods = this.goodsService.getGood(goodID);

        Cart cart = (Cart) this.session.getAttribute(constants.SESSION_CART);

        if (cart == null){
            cart = new Cart();

            this.session.setAttribute(constants.SESSION_CART,cart);
        }

        cart.addItem(goods,1);

        System.out.println(cart.getPrice());
        logger.info("添加商品："+cart.getCartItems());

        if (type == 1){             //type为1时跳转到我的购物车界面
            ret = "find";

            type = 0;
        }
        return ret;
    }

    public void showImage(){

        request = ServletActionContext.getRequest();

        response = ServletActionContext.getResponse();

        String url = imageUrl.substring(0,imageUrl.length()-3);

        com.czw.eshop.util.ZipImage.zip(request,response,url);
    }


}
