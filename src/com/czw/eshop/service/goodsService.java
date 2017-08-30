package com.czw.eshop.service;

import com.czw.eshop.entity.goods;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/8/26.
 */
public interface goodsService {

    public goods getGood(long goodID);

    public List<goods> getAllGoods();

    public void addGoods(goods good);

    public void deleteGood(long goodID);

    public void updateGood(goods good);

    public List<goods> getByPage(int pageNo ,int pageSize);

    public int maxsize();

    //public List<goods> findGoods();
}
