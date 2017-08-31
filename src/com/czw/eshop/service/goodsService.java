package com.czw.eshop.service;

import com.czw.eshop.entity.Goods;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/8/26.
 */
public interface goodsService {

    public Goods getGood(long goodID);

    public List<Goods> getAllGoods();

    public void addGoods(Goods good);

    public void deleteGood(long goodID);

    public void updateGood(Goods good);

    public List<Goods> getByPage(int pageNo ,int pageSize);

    public int maxsize();

    //public List<goods> findGoods();
}
