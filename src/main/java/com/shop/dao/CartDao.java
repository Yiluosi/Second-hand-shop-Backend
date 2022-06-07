package com.shop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shop.domain.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CartDao extends BaseMapper<Cart> {

    @Select("select a.id, a.commodityid, a.userphone, a.number, b.name commodityname,b.price,b.image from cart a left join commodity b on a.commodityid = b.id")
    List<Cart> getones();
    @Select("    select a.id, a.commodityid, a.userphone, a.number, b.name commodityname, b.price,b.image from cart a left join commodity b on a.commodityid = b.id where a.userphone = ${phone}")
    List<Cart> getByPhone(String phone);
}
