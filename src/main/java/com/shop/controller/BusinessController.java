package com.shop.controller;


import com.shop.controller.utils.R;
import com.shop.domain.Business;
import com.shop.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @GetMapping("/getones")
    public R getones(){
        return new R(true, businessService.list(null));
    }
    //根据商家状态获取特定类型商家
    @GetMapping("/flag/{flag}")
    public R getflag(@PathVariable Integer flag){
        return new R(true, businessService.selectByFlag(flag));
    }
    //获取单独的商家信息
    @GetMapping("/{phone}")
    public R getone(@PathVariable String phone){
        return new R(true, businessService.getByPhone(phone));
    }

    //登录
    @GetMapping("/login/{phone}/{password}")
    public R login(@PathVariable String phone, @PathVariable String password){
        System.out.println("login()...");
        try {
            Business temp = businessService.getByPhone(phone);
            System.out.println("password:" + password);
            System.out.println("temppassword:" + temp.getPassword());
            if(temp.getPassword().equals(password) && temp.getFlag() == 1){
                return new R(true, temp);
            } else if(temp.getPassword().equals(password) && temp.getFlag() == 0){
                return new R(false, temp, "请等待审核");
            } else if (!temp.getPassword().equals(password)){
                return new R(false, temp, "密码错误");
            } else{
                return new R(false, temp, "抱歉，该账号因违规被封禁");
            }
        }catch (Exception exception){
            return new R(false,"账号不存在");
        }
    }

    //商家注册
    @PostMapping
    public R save(@RequestBody Business business){
        Boolean flag = businessService.save(business);
        return new R(flag, flag?"注册成功":"注册失败");
    }

    //修改商家状态
    @PutMapping("/update/{phone}/{flag}")
    public R updateflag(@PathVariable("phone") String phone, @PathVariable("flag") String flag){
        System.out.println("updateflag()..." + phone + ":" + flag);
        return new R(true, businessService.updateflag(Integer.valueOf(flag), phone));
    }

    //删除商家
    @DeleteMapping("{phone}")
    public R delete(@PathVariable String phone){
        System.out.println("Business.delete()...");
        return new R(true, businessService.delete(phone));
    }
    //获取用户购买金额
    @PutMapping("/addMoney/{phone}/{money}")
    public R addMoney(@PathVariable String phone, @PathVariable Double money){
        Business temp = businessService.getByPhone(phone);
         double preMoney = temp.getMoney();
         money = preMoney + money;
         return new R(true, businessService.updateMoney(money, phone));
    }

    //为店家打分
    @PutMapping("/score/{phone}/{score}")
    public R updateScore(@PathVariable String phone, @PathVariable int score){
        Business temp = businessService.getByPhone(phone);
        double level = temp.getLevel() * temp.getNumber();
        level = level + score;
        temp.setNumber(temp.getNumber() + 1);
        level = level / temp.getNumber();
        return new R(true, businessService.updateScore(temp.getNumber(), level, phone));
    }

//    商家扣钱
    @PutMapping("/money/{phone}/{money}")
    public R getMoney(@PathVariable String phone,@PathVariable Double money){
        Business temp = businessService.getByPhone(phone);
        return new R(true, businessService.updateMoney(temp.getMoney() - money, phone));
    }

    //    退款
    @PutMapping("/refund/{business}/{money}")
    public R refundMoney(@PathVariable String business, @PathVariable Double money){
        Business byBusiness = businessService.getByBusiness(business);
        String phone = byBusiness.getPhone();
        Double temp =  byBusiness.getMoney() - money;
        return new R(true, businessService.updateMoney(temp,phone));
    }
}
