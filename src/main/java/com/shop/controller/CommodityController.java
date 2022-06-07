package com.shop.controller;

import com.shop.controller.utils.R;
import com.shop.domain.Commodity;
import com.shop.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.PrinterAbortException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@RestController
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @GetMapping("/getones")
    public R getones() {
        return new R(true, commodityService.list(null));
    }

    @GetMapping("{id}")
    public R getone(@PathVariable Integer id) {
        System.out.println("CommodityHandler.id...");
        return new R(true, commodityService.getById(id));
    }
     //搜索某个店铺的所有商品
    @GetMapping("/business/{phone}")
    public R getbusiness(@PathVariable String phone){
        System.out.println("getbusiness()...");
        return new R(true, commodityService.getByBusiness(phone));
    }
    //添加商品
    @PostMapping
    public R addcommodiy(@RequestBody Commodity commodity){
        System.out.println("addcommodity()...");
        Boolean flag = commodityService.save(commodity);
        return new R(flag, flag?"发布成功，请等待审核":"发布失败，请修改信息");
    }
    //删除商品
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){
        System.out.println("User.delete()...");
        return new R(true, commodityService.removeById(id));
    }
    //商品状态
    @PutMapping("/update/{id}/{flag}")
    public R updatelevel(@PathVariable("id") String id, @PathVariable("flag") Integer flag){
        System.out.println("updatelevel()..." + id + ":" + flag);
        return new R(true, commodityService.updateflag(flag, id));
    }
    //根据商品状态查找
    @GetMapping("/flag/{flag}")
    public R getByFlag(@PathVariable Integer flag){
        System.out.println("getByFlag()...");
        return new R(true, commodityService.getByFlag(flag));
    }
    //商品评分
    @PutMapping("/score/{id}/{score}")
    public R updateScore(@PathVariable Integer id, @PathVariable Integer score){
        Commodity temp = commodityService.getById(id);
        temp.setScore(temp.getScore() + score);
        temp.setSales(temp.getSales() + 1);
        if(temp.getStock() > 1){
            temp.setStock(temp.getStock() - 1);
        }
        return new R(true, commodityService.updateById(temp));
    }
    // 模糊搜索
    @GetMapping("/getxxx/{name}")
    public R getXxx(@PathVariable String name) throws UnsupportedEncodingException {
        String str= URLDecoder.decode(name,"utf-8");
        System.out.println(str);
        return new R(true, commodityService.getXxx(str));
    }

//    排序
    @GetMapping("/getOrder/{order}")
    public R getOrder(@PathVariable String order){
        return new R(true, commodityService.getOrder(order));
    }

//    模糊搜索的排序

}
