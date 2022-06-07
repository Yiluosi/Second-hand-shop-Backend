package com.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.dao.CartDao;
import com.shop.domain.Cart;

import java.util.List;

public interface CartService extends IService<Cart> {
    List<Cart> getones();
    List<Cart> getByPhone(String phone);
}
