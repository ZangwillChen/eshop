package com.czw.eshop.service;

import com.czw.eshop.dao.BaseDao;
import com.czw.eshop.entity.Goods;

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
    public Goods getGood(long goodID) {
        return baseDao.getEntityById(Goods.class,goodID );
    }

    @Override
    public List<Goods> getAllGoods() {
        return baseDao.getAllEntity("Goods");

    }

    @Override
    public void addGoods(Goods good) {
        this.baseDao.saveEntity(good);
    }

    @Override
    public void deleteGood(long goodID) {
        this.baseDao.deleteEntityById(Goods.class,goodID);
    }

    @Override
    public void updateGood(Goods good) {
        this.baseDao.updateEntity(good);
    }

    @Override
    public List<Goods> getByPage(int pageNo, int pageSize) {

        String hql = "from Goods ";

        int real = baseDao.realPage(hql);

        return baseDao.getbyPage(hql,pageNo,pageSize,real);
    }

    @Override
    public int maxsize() {

        String hql = "from Goods";

        int count = 0;

        int maxpage = 0;

        count = baseDao.realPage(hql);

        maxpage = (count + 4)/5;

        return maxpage;
    }
}
