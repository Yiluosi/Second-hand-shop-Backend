package com.shop.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.dao.CommodityDao;
import com.shop.domain.Commodity;
import com.shop.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityDao, Commodity> implements CommodityService {

    @Autowired
    private CommodityDao commodityDao;

    @Override
    public IPage<Commodity> getPage(int currentPage, int pageSize) {
        return null;
    }

    @Override
    public IPage<Commodity> getPage(int currentPage, int pageSize, Commodity commodity) {
        return null;
    }

    @Override
    public List<Commodity> getByBusiness(String business) {
        return commodityDao.getByBusiness(business);
    }

    @Override
    public int updateflag(Integer param1, String param2) {
        return commodityDao.updateflag(param1, param2);
    }

    @Override
    public List<Commodity> getByFlag(Integer flag) {
        return commodityDao.getByFlag(flag);
    }

    @Override
    public List<Commodity> getXxx(String name) {
        return commodityDao.getXxx(name);
    }

    @Override
    public List<Commodity> getOrder(String order) {
        return commodityDao.getOrder(order);
    }

}
