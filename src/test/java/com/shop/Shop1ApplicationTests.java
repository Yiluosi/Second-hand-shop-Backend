package com.shop;

import com.shop.dao.ComUserDao;
import com.shop.dao.CommodityDao;
import com.shop.service.CommodityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Shop1ApplicationTests {

    @Autowired
    private ComUserDao comUserDao;

    @Autowired
    private CommodityDao commodityDao;

    @Test
    void comuser() {
//        System.out.println(comUserDao.selectList(null));
        System.out.println(comUserDao.selectById("18810713430"));
//        System.out.println(comUserDao.selectByLevel(1));
    }

    @Test
    void commodity() {
        System.out.println(commodityDao.selectList(null));
    }


    @Autowired
    private CommodityService commodityService;

    @Test
    void commodityservice() {
        System.out.println(commodityService.getById(1));
    }

}
