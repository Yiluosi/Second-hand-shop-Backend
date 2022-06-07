package com.shop.controller;

import com.alibaba.fastjson.JSONArray;
import com.shop.controller.utils.R;
import com.shop.domain.Cart;
import com.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/getones")
    public R getones(){
        return new R(true, cartService.getones());
    }
    //某个用户的购物车
    @GetMapping("/getone/{phone}")
    public R getByPhone(@PathVariable String phone){
        return new R(true, cartService.getByPhone(phone));
    }
    //添加购物车
    @PostMapping
    public R addCommodity(@RequestBody Cart cart){
        return new R(true, cartService.save(cart));
    }
    //购买之后就在购物车列表删除了
    @PostMapping("/submit")
    public R deleteCommodity(@RequestBody String carts) throws UnsupportedEncodingException {
        // 方法麻烦了，其实直接返回购物车ID就可以了，这里返回了整个购物车的数据
        String jsonStr=URLDecoder.decode(carts,"utf-8");
        System.out.println(jsonStr);
        List<Cart> carts1 = JSONArray.parseArray(jsonStr, Cart.class);
        System.out.println(carts1.toString());
        int i = 0;
        while(i < carts1.size()){
            System.out.println(carts1.get(i).getId());
            cartService.removeById(carts1.get(i).getId());
            i++;
        }
        return new R(true, carts1.size(),"操作成功");
    }
    //删除
    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable Integer id){
        return new R(true, cartService.removeById(id));
    }
    //数量+1
    @PutMapping("/add/{id}")
    public R addById(@PathVariable Integer id){
        Cart cart = cartService.getById(id);
        cart.setNumber(cart.getNumber()+1);
        return new R(true, cartService.updateById(cart));
    }
    //数量-1
    @PutMapping("/reduce/{id}")
    public R reduceById(@PathVariable Integer id){
        Cart cart = cartService.getById(id);
        cart.setNumber(cart.getNumber()-1);
        return new R(true, cartService.updateById(cart));
    }

}
