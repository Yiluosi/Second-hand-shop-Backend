package com.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.domain.Bill;

import java.util.List;

public interface BillService extends IService<Bill> {
    List<Bill> getByPhone(String phone);
    List<Bill> selectByFlag(String param1, Integer param2);
}
