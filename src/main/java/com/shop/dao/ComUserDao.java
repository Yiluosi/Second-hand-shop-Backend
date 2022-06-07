package com.shop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shop.domain.ComUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ComUserDao extends BaseMapper<ComUser> {

    @Select("SELECT * FROM comuser WHERE comuser_phone=${id}")
    List<ComUser> selectById(String id);

    @Select("select * from comuser where comuser_level=${level}")
    List<ComUser> selectByLevel(Integer level);

    @Delete("DELETE FROM comuser WHERE comuser_phone='${phone}'")
    int delete(String phone);

//    mybatis的参数必须要写成paramx的形式
    @Update("UPDATE comuser SET comuser_level=${param1} WHERE comuser_phone='${param2}'")
    int updatelevel(Integer param1, String param2);

    @Select("SELECT * FROM comuser WHERE comuser_phone=${param2} and comuser_level=${param1}")
    ComUser selectByIdLevel(Integer param1, String param2);

    @Update("UPDATE comuser SET comuser_money=${param1} WHERE comuser_phone='${param2}'")
    int addMoney(Double param1, String param2);

    @Update("UPDATE comuser SET comuser_money=${param1} WHERE comuser_phone='${param2}'")
    int reduceMoney(Double param1, String param2);

    @Update("UPDATE comuser SET comuser_address='${param2}', comuser_wechat='${param3}', comuser_mail='${param4}', comuser_information='${param5}', comuser_bankaccount='${param6}' WHERE comuser_phone='${param1}'")
    int updateInfo(String param1, String param2, String param3, String param4, String param5, String param6);
}
