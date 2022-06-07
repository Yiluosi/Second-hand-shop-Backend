package com.shop.controller;

import com.shop.controller.utils.R;
import com.shop.domain.EvalCommodity;
import com.shop.service.EvalCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evalcommodity")
public class EvalCommodityController {
    @Autowired
    private EvalCommodityService evalCommodityService;

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, evalCommodityService.getById(id));
    }

    @GetMapping("/getcommodity/{commodityid}")
    public R getByCommodityId(@PathVariable Integer commodityid){
        return new R(true, evalCommodityService.selectByCommodityId(commodityid));
    }

    @PostMapping
    public R save(@RequestBody EvalCommodity evalCommodity){
        return new R(true, evalCommodityService.save(evalCommodity));
    }

    @GetMapping("/getcommodity/{commodityid}/{phone}")
    public R getByUserCom(@PathVariable Integer commodityid, @PathVariable String phone){
        return new R(true, evalCommodityService.selectByUserCom(commodityid, phone));
    }
}
