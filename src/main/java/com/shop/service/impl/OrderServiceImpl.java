package com.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.dao.OrderDao;
import com.shop.domain.Order;
import com.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> selectByPhone(String phone) {
        return orderDao.selectByPhone(phone);
    }

    @Override
    public List<Order> selectByBusiness(String business) {
        return orderDao.selectByBusiness(business);
    }
}
