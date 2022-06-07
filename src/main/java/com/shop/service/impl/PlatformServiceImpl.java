package com.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.dao.PlatformDao;
import com.shop.domain.Platform;
import com.shop.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatformServiceImpl extends ServiceImpl<PlatformDao, Platform> implements PlatformService {
    @Autowired
    private PlatformDao platformDao;
}
