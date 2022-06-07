package com.shop.controller;

import com.shop.controller.utils.R;
import com.shop.domain.ComUser;
import com.shop.service.BillService;
import com.shop.service.ComUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comuser")
public class ComUserController {

    @Autowired
    private ComUserService comUserService;

    //查找所有用户
    @GetMapping("/getones")
    public R getones(){
        return new R(true, comUserService.list(null));
    }
    //查找特定用户
    @GetMapping("/{phone}")
    public R getone(@PathVariable String phone) {
        return new R(true, comUserService.getById(phone));
    }
    //用户注册
    @PostMapping
    public R save(@RequestBody ComUser comUser){
        Boolean flag = comUserService.save(comUser);
        return new R(flag, flag?"注册成功":"注册失败");
    }
    //根据用户类型查找
    @GetMapping("/screen/{level}")
    public R getLevel(@PathVariable Integer level){
        System.out.println("getLevel()....");
        return new R(true, comUserService.getByLevel(level));
    }
    //根据用户类型和电话查找
    @GetMapping("/one/{phone}")
    public R getoneId(@PathVariable String phone){
        System.out.println("getByIdLevel()...");
        return new R(true, comUserService.selectById(phone));
    }
    //登录
    @GetMapping("/login/{phone}/{password}/{level}")
    public R login(@PathVariable String phone, @PathVariable String password, @PathVariable Integer level){
        System.out.println("login()...");
        try {
            ComUser temp = comUserService.getById(phone);
            System.out.println("password:" + password);
            System.out.println("temppassword:" + temp.getComuserPassword());
            System.out.println("level:" + temp.getComuserLevel());
            if(temp.getComuserPassword().equals(password) && temp.getComuserLevel().equals(level)){
                return new R(true, temp);
            } else if(temp.getComuserPassword().equals(password) && !temp.getComuserLevel().equals(level)){
                return new R(false, temp, "用户类型错误");
            } else{
                return new R(false, temp, "密码错误");
            }
        }catch (Exception exception){
            return new R(false,"账号不存在");
        }
    }
    //删除用户
    @DeleteMapping("/{phone}")
    public R delete(@PathVariable String phone){
        System.out.println("User.delete()...");
        return new R(true, comUserService.delete(phone));
    }
    //封号、解封、通过申请
    @PutMapping("/update/{phone}/{level}")
    public R updatelevel(@PathVariable("phone") String phone, @PathVariable("level") String level){
        System.out.println("updatelevel()..." + phone + ":" + level);
        return new R(true, comUserService.updatelevel(Integer.valueOf(level), phone));
    }
    //充值
    @PutMapping("/addMoney/{phone}/{money}")
    public R addMoney(@PathVariable String phone, @PathVariable Double money){
        System.out.println("addMoney()..." + phone + ":" + money);
        ComUser temp = comUserService.getById(phone);
        money = money + temp.getComuserMoney();
        return new R(true, comUserService.addMoney(money, phone));
    }
    //扣费
    @PutMapping("/reduceMoney/{phone}/{money}")
    public R reduceMoney(@PathVariable String phone, @PathVariable Double money){
        System.out.println("addMoney()..." + phone + ":" + money);
        ComUser temp = comUserService.getById(phone);
        money = temp.getComuserMoney() - money;
        return new R(true, comUserService.reduceMoney(money, phone));
    }
    // 更新用户信息
    @PostMapping("/updateInfo")
    public R updateInfo(@RequestBody ComUser comUser){
        String phone = comUser.getComuserPhone();
        String address = comUser.getComuserAddress();
        String wechat = comUser.getComuserWechat();
        String mail = comUser.getComuserMail();
        String information = comUser.getComuserInformation();
        String bankaccount = comUser.getComuserBankaccount();
        return new R(true, comUserService.updateInfo(phone, address, wechat, mail, information, bankaccount));
    }

}
