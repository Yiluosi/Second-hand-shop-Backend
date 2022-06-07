package com.shop.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shop.controller.utils.R;
import com.shop.domain.*;
import com.shop.service.BusinessService;
import com.shop.service.CommodityService;
import com.shop.service.OrderService;
import com.shop.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CommodityService commodityService;
    @Autowired
    private PlatformService platformService;
    @Autowired
    private BusinessService businessService;

    @GetMapping("/getones")
    public R getOnes(){
        return new R(true,orderService.list(null));
    }

    @GetMapping("/getone/{phone}")
    public R getByPhone(@PathVariable String phone){
        return new R(true, orderService.selectByPhone(phone));
    }

    @GetMapping("/business/{phone}")
    public R getByBusiness(@PathVariable String phone) throws UnsupportedEncodingException {
        String jsonStr=URLDecoder.decode(phone,"utf-8");
        return new R(true, orderService.selectByBusiness(jsonStr));
    }

    @PostMapping
    public R postOrder(@RequestBody String order) throws UnsupportedEncodingException {
        String jsonStr=URLDecoder.decode(order,"utf-8");
        List<Order> orders = JSONArray.parseArray(jsonStr, Order.class);
        for(int i = 0; i < orders.size(); i++){
            Commodity commodity = commodityService.getById(orders.get(i).getCommodityid());
            orders.get(i).setBusiness(commodity.getBusname());
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            orders.get(i).setTime(format.format(date));
            orderService.save(orders.get(i));
            // 暂存
            Platform temp = platformService.getById(1);
            temp.setTempmoney(temp.getTempmoney() + orders.get(i).price*orders.get(i).number);
            platformService.updateById(temp);
        }
        return new R(true, orders.size());
    }

    @PostMapping("/buynow")
    public R buyNow(@RequestBody Order order){
        Commodity commodity = commodityService.getById(order.getCommodityid());
        order.setBusiness(commodity.getBusname());
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        order.setTime(format.format(date));
        return new R(true, orderService.save(order)
        );
    }
    //修改状态
    @PutMapping("/update/{id}/{flag}")
    public R updateFlag(@PathVariable Integer id, @PathVariable Integer flag){
        Order order = orderService.getById(id);
        order.setFlag(flag);
        if(flag == 3){
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            order.setTime(format.format(date));
        }
        // 平台扣钱，商家加钱
        if(flag == 4){
            Platform temp = platformService.getById(1);
            temp.setTempmoney(temp.getTempmoney() - order.price*order.number);
            platformService.updateById(temp);

            Business business = businessService.getByBusiness(order.getBusiness());
            Double money = business.getMoney() + order.price*order.number;
            businessService.updateMoney(money, business.getPhone());
        }
        return new R(true, orderService.updateById(order));
    }

    //删除订单
    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable Integer id){
        return new R(true, orderService.removeById(id));
    }
}
