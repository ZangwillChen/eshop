package com.czw.eshop.service;

import com.czw.eshop.entity.goods;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/8/26.
 */
public interface goodsService {

    public goods getGood(long goodID);

    public List<goods> getAllGoods();


}
