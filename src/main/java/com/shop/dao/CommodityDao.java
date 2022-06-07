package com.shop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shop.domain.ComUser;
import com.shop.domain.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CommodityDao extends BaseMapper<Commodity> {
    @Select("SELECT * FROM commodity WHERE id=${id}")
    Commodity selectById(Integer id);

    @Select("select * from commodity where business=${business}")
    List<Commodity> getByBusiness(String business);

    @Update("UPDATE commodity SET flag=${param1} WHERE id=${param2}")
    int updateflag(Integer param1, String param2);

    @Select("select * from commodity where flag=${flag}")
    List<Commodity> getByFlag(Integer flag);

    @Select("select * from commodity where name like '%${name}%'")
    List<Commodity> getXxx(String name);

    @Select("select * from commodity ORDER BY price ${order}")
    List<Commodity> getOrder(String order);
}
