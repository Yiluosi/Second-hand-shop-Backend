package com.shop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shop.domain.Bill;
import com.shop.domain.ComUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BillDao extends BaseMapper<Bill> {
    @Select("SELECT * FROM bill WHERE userphone=${phone}")
    List<Bill> selectByPhone(String phone);

    @Select("SELECT * FROM bill WHERE userphone='${param1}' and bian=${param2}")
    List<Bill> selectByFlag(String param1, Integer param2);

}
