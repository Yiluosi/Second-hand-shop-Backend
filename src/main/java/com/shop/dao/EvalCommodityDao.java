package com.shop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shop.domain.EvalCommodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EvalCommodityDao extends BaseMapper<EvalCommodity> {
    @Select("select * from evalcommodity where commodityid=${commodityid}")
    List<EvalCommodity> selectByCommodityId(Integer commodityid);

    @Select("select * from evalcommodity where commodityid=${param1} and userphone=${param2}")
    EvalCommodity selectByUserCom(Integer param1, String param2);
}
