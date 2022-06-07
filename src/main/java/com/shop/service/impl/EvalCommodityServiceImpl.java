package com.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.dao.EvalCommodityDao;
import com.shop.domain.EvalCommodity;
import com.shop.service.EvalCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvalCommodityServiceImpl extends ServiceImpl<EvalCommodityDao, EvalCommodity> implements EvalCommodityService {
    @Autowired
    private EvalCommodityDao evalCommodityDao;

    @Override
    public List<EvalCommodity> selectByCommodityId(Integer commodityid) {
        return evalCommodityDao.selectByCommodityId(commodityid);
    }

    @Override
    public EvalCommodity selectByUserCom(Integer param1, String param2) {
        return evalCommodityDao.selectByUserCom(param1, param2);
    }
}
