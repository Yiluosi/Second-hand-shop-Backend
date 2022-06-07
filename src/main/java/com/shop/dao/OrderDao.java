package com.shop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shop.domain.Bill;
import com.shop.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderDao extends BaseMapper<Order> {
    @Select("SELECT * FROM orders WHERE userphone=${phone}")
    List<Order> selectByPhone(String phone);

    @Select("SELECT * FROM orders WHERE business='${business}'")
    List<Order> selectByBusiness(String business);
}
