package com.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.dao.CartDao;
import com.shop.domain.Cart;
import com.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl extends ServiceImpl<CartDao, Cart> implements CartService {

    @Autowired
    private CartDao cartDao;

    @Override
    public List<Cart> getones() {
        return cartDao.getones();
    }

    @Override
    public List<Cart> getByPhone(String phone) {
        return cartDao.getByPhone(phone);
    }
}
