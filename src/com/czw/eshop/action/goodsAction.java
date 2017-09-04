package com.czw.eshop.action;

import com.czw.eshop.dto.GoodsDTO;
import com.czw.eshop.entity.Goods;
import com.czw.eshop.service.goodsService;
import com.czw.eshop.util.UploadUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.fileupload.UploadContext;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by chenzhaowen on 2017/8/26.
 */
public class goodsAction extends ActionSupport implements ModelDriven {

    private goodsService goodsservice;

    private GoodsDTO goodsDTO = new GoodsDTO();

    private List<Goods> goodsList;

    private HttpServletRequest request;

    private HttpServletResponse response;

    private Goods good;

    private Goods updateGood;

    //添加分页

    private int page;

    private int maxpage;

    private long goodID;

    @Override
    public Object getModel() {
        return goodsDTO;
    }

    public goodsService getGoodsservice() {
        return goodsservice;
    }

    public void setGoodsservice(goodsService goodsservice) {
        this.goodsservice = goodsservice;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
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

    public Goods getUpdateGood() {
        return updateGood;
    }

    public void setUpdateGood(Goods updateGood) {
        this.updateGood = updateGood;
    }

    public String addGood(){

        Goods good = new Goods();

        String imagePath = UploadUtil.upload(goodsDTO.getFile());

        good.setImgSrc(imagePath);

        good.set(goodsDTO);

        goodsservice.addGoods(good);

        return "success";
    }

    public String updateGood(){
        updateGood = this.goodsservice.getGood(goodID);

        this.saveGood();

        return "update";
    }

    public String saveGood(){

        String imagepath = UploadUtil.upload(goodsDTO.getFile());

        updateGood.setGoodName(goodsDTO.getName());

        updateGood.setGoodPrice(goodsDTO.getPrice());

        updateGood.setDescription(goodsDTO.getDescription());

        updateGood.setImgSrc(imagepath);

        System.out.println(updateGood.getGoodName());

        this.goodsservice.updateGood(updateGood);

        return "save";
    }


    public void deleteGood(){

        this.goodsservice.deleteGood(goodID);
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
