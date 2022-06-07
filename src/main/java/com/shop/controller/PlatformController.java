package com.shop.controller;


import com.shop.controller.utils.R;
import com.shop.domain.Platform;
import com.shop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/platform")
public class PlatformController {

    @Autowired
    private PlatformService platformService;
    @Autowired
    private ComUserService comUserService;
    @Autowired
    private CommodityService commodityService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private BusinessService businessService;

    @GetMapping("/info")
    public R getInfo(){
        return new R(true, platformService.getById(1));
    }

    @PostMapping
    public R update(@RequestBody Platform platform){
        Integer sumuser = comUserService.list().size();
        Integer sumcommodity = commodityService.list().size();
        Integer sumorder = orderService.list().size();
        Integer sumbusiness = businessService.list().size();
        Platform temp = platformService.getById(1);
        temp.setSumuser(sumuser);
        temp.setSumcommodity(sumcommodity);
        temp.setSumorder(sumorder);
        temp.setSumbusiness(sumbusiness);
        System.out.println(sumuser + sumcommodity + sumorder + sumbusiness);
        return new R(true, platformService.updateById(temp));
    }

    //提现，就是把钱提走一部分
    @PutMapping("/withdrawal/{profit}")
    public R withdrawal(@PathVariable Double profit){
        Platform temp = platformService.getById(1);
        temp.setProfit(temp.getProfit() - profit);
        return new R(true, platformService.updateById(temp));
    }

//    平台增加暂存金额
    @PutMapping("/money/{money}")
    public R putMoney(@PathVariable Double money){
        Platform temp = platformService.getById(1);
        temp.setTempmoney(temp.getTempmoney() + money);
        return new R(true, platformService.updateById(temp));
    }
    //    减少平台暂存金额
    @PutMapping("/reducemoney/{money}")
    public R reduceMoney(@PathVariable Double money){
        Platform temp = platformService.getById(1);
        temp.setProfit(temp.getProfit() - money);
        return new R(true, platformService.updateById(temp));
    }
    //    平台增加收益
    @PutMapping("/profit/{money}")
    public R putProfit(@PathVariable Double money){
        Platform temp = platformService.getById(1);
        temp.setProfit(temp.getProfit() + money);
        return new R(true, platformService.updateById(temp));
    }

}
