package com.shop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.domain.ComUser;
import com.shop.domain.Commodity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommodityService extends IService<Commodity> {
    IPage<Commodity> getPage(int currentPage, int pageSize);
    IPage<Commodity> getPage(int currentPage, int pageSize, Commodity commodity);
    List<Commodity> getByBusiness(String business);
    int updateflag(Integer param1, String param2);
    List<Commodity> getByFlag(Integer flag);
    List<Commodity> getXxx(String name);
    List<Commodity> getOrder(String order);
}
