package com.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.domain.Order;

import java.util.List;

public interface OrderService extends IService<Order> {
    List<Order> selectByPhone(String phone);
    List<Order> selectByBusiness(String business);

}
