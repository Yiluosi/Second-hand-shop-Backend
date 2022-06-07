package com.shop.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("orders")
public class Order {
    public int id;
    public String userphone;
    public int commodityid;
    public int number;
    public String time;
    public String business;
    public String image;
    public double price;
    public int flag;
    public String commodityname;
}
