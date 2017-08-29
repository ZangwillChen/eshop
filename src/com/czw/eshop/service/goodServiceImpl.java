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

    @Override
    public void addGoods(goods good) {
        this.baseDao.updateEntity(good);
    }

    @Override
    public void deleteGood(long goodID) {
        this.baseDao.deleteEntityById(goods.class,goodID);
    }

    @Override
    public void updateGood(goods good) {
        this.baseDao.updateEntity(good);
    }

    @Override
    public List<goods> getByPage(int pageNo, int pageSize) {

        String hql = "from goods";

        int real = baseDao.realPage(hql);

        return baseDao.getbyPage(hql,pageNo,pageSize,real);
    }

    @Override
    public int maxsize() {

        String hql = "from goods";

        int count = 0;

        int maxpage = 0;

        count = baseDao.realPage(hql);

        maxpage = (count + 4)/5;

        return maxpage;
    }
}
