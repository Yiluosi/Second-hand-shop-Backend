package com.shop.controller;

import com.alibaba.fastjson.JSONArray;
import com.shop.controller.utils.R;
import com.shop.domain.Bill;
import com.shop.domain.ComUser;
import com.shop.domain.Order;
import com.shop.service.BillService;
import com.shop.service.ComUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private BillService billService;
    @Autowired
    private ComUserService comUserService;

    @GetMapping("/getones")
    public R getOnes(){
        System.out.println("getOnes()...");
        return new R(true, billService.list(null));
    }

    @GetMapping("/getone/{phone}")
    public R getByPhone(@PathVariable String phone){
        return new R(true, billService.getByPhone(phone));
    }
    //格局flag查询
    @GetMapping("/getone/{phone}/{flag}")
    public R getByPhone(@PathVariable String phone, @PathVariable Integer flag){
        return new R(true, billService.selectByFlag(phone, flag));
    }

    //充值
    @PostMapping("/recharge/{phone}/{money}")
    public R record(@PathVariable String phone, @PathVariable Double money){
        System.out.println("record()...");
        Bill bill = new Bill();
        bill.setUserphone(phone);
        bill.setMoney(money);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        bill.setBian(0);
        bill.setTime(format.format(date));

        ComUser temp = comUserService.getById(bill.getUserphone());
        money = money + temp.getComuserMoney();
        comUserService.addMoney(money, bill.getUserphone());

        return new R(true, billService.save(bill));
    }
    //买东西
    @PostMapping("/shopping")
    public R shopping(@RequestBody String bill) throws UnsupportedEncodingException {
        String jsonStr= URLDecoder.decode(bill,"utf-8");
        System.out.println(jsonStr);
        List<Bill> bills = JSONArray.parseArray(jsonStr, Bill.class);
        for(int i = 0; i < bills.size(); i++){
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            bills.get(i).setTime(format.format(date));
            bills.get(i).setBian(1);
            billService.save(bills.get(i));

            ComUser temp = comUserService.getById(bills.get(i).getUserphone());
            Double money = temp.getComuserMoney();
            money = money + bills.get(i).getMoney();
            comUserService.reduceMoney(money, bills.get(i).getUserphone());
        }
        return new R(true, bills.size());
    }

    //买东西
    @PostMapping("/shopping/one")
    public R shopping(@RequestBody Bill bill) throws UnsupportedEncodingException {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        bill.setTime(format.format(date));
        bill.setBian(1);

        ComUser temp = comUserService.getById(bill.getUserphone());
        Double money = temp.getComuserMoney();
        money = money - bill.getMoney();
        comUserService.reduceMoney(money, bill.getUserphone());
        return new R(true, billService.save(bill));
    }
    //退款
    @PostMapping("/refund/{phone}/{money}")
    public R refund(@PathVariable String phone, @PathVariable Double money){
        Bill bill = new Bill();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        bill.setTime(format.format(date));
        bill.setBian(2);
        bill.setUserphone(phone);
        bill.setMoney(money);

        ComUser temp = comUserService.getById(phone);
        Double mon =money + temp.getComuserMoney();
        comUserService.addMoney(mon, phone);

        return new R(true, billService.save(bill));
    }
}
