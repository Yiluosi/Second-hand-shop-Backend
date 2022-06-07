package com.shop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shop.domain.Business;
import com.shop.domain.ComUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BusinessDao extends BaseMapper<Business> {
    @Select("select * from business where flag=${flag}")
    List<Business> selectByFlag(Integer flag);

    @Select("SELECT * FROM business WHERE phone=${phone} ")
    Business getByPhone(String phone);

    @Select("SELECT * FROM business WHERE name='${business}'")
    Business getByBusiness(String business);

    @Delete("DELETE FROM business WHERE phone='${phone}'")
    int delete(String phone);

    @Update("UPDATE business SET flag=${param1} WHERE phone=${param2}")
    int updateflag(Integer param1, String param2);

    @Update("UPDATE business SET money=${param1} WHERE phone=${param2}")
    int updateMoney(Double param1, String param2);

    @Update("UPDATE business SET number=${param1}, level=${param2} WHERE phone=${param3}")
    int updateScore(Integer param1, Double param2, String param3);
}
