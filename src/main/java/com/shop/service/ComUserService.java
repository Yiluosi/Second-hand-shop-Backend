package com.shop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.domain.ComUser;

import java.util.List;


public interface ComUserService extends IService<ComUser> {
    IPage<ComUser> getPage(int currentPage, int pageSize);
    IPage<ComUser> getPage(int currentPage, int pageSize, ComUser comUser);
    List<ComUser> getByLevel(Integer level);
    int delete(String phone);
    int updatelevel(Integer level, String phone);
    ComUser getByIdLevel(Integer level, String phone);
    List<ComUser> selectById(String id);
    int addMoney(Double param1, String param2);
    int reduceMoney(Double param1, String param2);
    int updateInfo(String param1, String param2, String param3, String param4, String param5, String param6);
}
