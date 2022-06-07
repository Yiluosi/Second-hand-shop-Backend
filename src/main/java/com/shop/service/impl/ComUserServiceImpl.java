package com.shop.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.dao.ComUserDao;
import com.shop.domain.ComUser;
import com.shop.service.ComUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComUserServiceImpl extends ServiceImpl<ComUserDao, ComUser> implements ComUserService {
    @Autowired
    private ComUserDao comUserDao;

    @Override
    public IPage<ComUser> getPage(int currentPage, int pageSize) {
        return null;
    }

    @Override
    public IPage<ComUser> getPage(int currentPage, int pageSize, ComUser comUser) {
        return null;
    }

    @Override
    public List<ComUser> getByLevel(Integer level){
        return comUserDao.selectByLevel(level);
    }

    @Override
    public int delete(String phone) {
        return comUserDao.delete(phone);
    }

    @Override
    public int updatelevel(Integer level, String phone) {
        return comUserDao.updatelevel(level, phone);
    }

    @Override
    public ComUser getByIdLevel(Integer level, String phone) {
        return comUserDao.selectByIdLevel(level, phone);
    }

    @Override
    public List<ComUser> selectById(String id) {
        return comUserDao.selectById(id);
    }

    @Override
    public int addMoney(Double param1, String param2) {
        return comUserDao.addMoney(param1, param2);
    }

    @Override
    public int reduceMoney(Double param1, String param2) {
        return comUserDao.reduceMoney(param1, param2);
    }

    @Override
    public int updateInfo(String param1, String param2, String param3, String param4, String param5, String param6) {
        return comUserDao.updateInfo(param1, param2, param3, param4, param5, param6);
    }


}
