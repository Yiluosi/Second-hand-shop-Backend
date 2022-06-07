package com.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.dao.BillDao;
import com.shop.domain.Bill;
import com.shop.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl extends ServiceImpl<BillDao, Bill> implements BillService {
    @Autowired
    private BillDao billDao;
    @Override
    public List<Bill> getByPhone(String phone) {
        return billDao.selectByPhone(phone);
    }

    @Override
    public List<Bill> selectByFlag(String param1, Integer param2) {
        return billDao.selectByFlag(param1, param2);
    }
}
