package com.czw.eshop.test;

import com.czw.eshop.entity.Goods;
import com.czw.eshop.service.goodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenzhaowen on 2017/9/1.
 */
public class GoodTest {

    @Test
    public void get(){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-common.xml");

        goodsService Service = (goodsService) context.getBean("goodsServiceTarget");

        Goods good1 = Service.getGood((long)3);

        System.out.println(good1.getGoodName());

        List<Goods> goods = Service.getAllGoods();

        for (Goods good :goods){
            System.out.println(good.getGoodName());
        }

    }

    @Test
    public void add(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-common.xml");

        goodsService Service = (goodsService) context.getBean("goodsServiceTarget");

        Goods goods = new Goods();

        goods.setGoodPrice(100.2);

        goods.setGoodName("水杯");

        goods.setInventory("20");

        goods.setImgSrc("/User/chenzhaowen/Desktop/shuibei.jpg");

        Service.addGoods(goods);
    }

    @Test
    public void delete(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-common.xml");

        goodsService Service = (goodsService) context.getBean("goodsServiceTarget");

        Service.deleteGood(Long.valueOf(5));
    }

    @Test
    public void update(){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-common.xml");

        goodsService Service = (goodsService) context.getBean("goodsServiceTarget");

        Goods goods = new Goods();

        goods.setGoodID(Long.valueOf(4));

        goods.setGoodName("水壶");

        goods.setGoodPrice(88);

        goods.setInventory("100");

        Service.updateGood(goods);
    }

    @Test
    public void maxsize(){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-common.xml");

        goodsService Service = (goodsService) context.getBean("goodsServiceTarget");

        int max = Service.maxsize();

        System.out.println(max);
    }

    @Test
    public void byPage(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-common.xml");

        goodsService Service = (goodsService) context.getBean("goodsServiceTarget");

        List<Goods> list = new ArrayList<>();

        list = Service.getByPage(1,5);

        System.out.println(list.size());
    }

}
