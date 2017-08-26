package com.czw.eshop.service;

import com.czw.eshop.dao.BaseDao;
import com.czw.eshop.entity.goods;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/8/26.
 */
public class goodServiceImpl implements goodsService {

    private BaseDao baseDao;

    public BaseDao getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public goods getGood(long goodID) {
        return baseDao.getEntityById(goods.class,goodID );
    }

    @Override
    public List<goods> getAllGoods() {
        return baseDao.getAllEntity("goods");

    }
}
