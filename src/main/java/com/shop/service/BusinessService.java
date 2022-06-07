package com.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.domain.Business;

import java.util.List;

public interface BusinessService extends IService<Business> {
    List<Business> selectByFlag(Integer flag);
    Business getByPhone(String phone);
    int delete(String phone);
    int updateflag(Integer param1, String param2);
    int updateMoney(Double param1, String param2);
    int updateScore(Integer param1, Double param2, String param3);
    Business getByBusiness(String business);
}
