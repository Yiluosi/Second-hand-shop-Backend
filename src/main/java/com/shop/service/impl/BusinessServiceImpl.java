package com.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.dao.BusinessDao;
import com.shop.domain.Business;
import com.shop.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessDao, Business> implements BusinessService {

    @Autowired
    private BusinessDao businessDao;

    @Override
    public List<Business> selectByFlag(Integer flag) {
        return businessDao.selectByFlag(flag);
    }

    @Override
    public Business getByPhone(String phone) {
        return businessDao.getByPhone(phone);
    }

    @Override
    public int delete(String phone) {
        return businessDao.delete(phone);
    }

    @Override
    public int updateflag(Integer param1, String param2) {
        return businessDao.updateflag(param1, param2);
    }

    @Override
    public int updateMoney(Double param1, String param2) {
        return businessDao.updateMoney(param1, param2);
    }

    @Override
    public int updateScore(Integer param1, Double param2, String param3) {
        return businessDao.updateScore(param1, param2, param3);
    }

    @Override
    public Business getByBusiness(String business) {
        return businessDao.getByBusiness(business);
    }
}
