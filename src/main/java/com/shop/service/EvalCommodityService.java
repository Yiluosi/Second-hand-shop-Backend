package com.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.domain.EvalCommodity;

import java.util.List;


public interface EvalCommodityService extends IService<EvalCommodity> {

    List<EvalCommodity> selectByCommodityId(Integer commodityid);
    EvalCommodity selectByUserCom(Integer param1, String param2);
}
