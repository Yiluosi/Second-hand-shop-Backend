package com.shop.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("business")
public class Business {
    private String phone;
    private String password;
    private String name;
    private double level; //商家等级
    private String image; //商家头像
    private String licenseimage; //营业执照
    private String license; //营业执照ID
    private int number; //购买次数
    private int flag; //店铺状态 0-审核 1-开店 2-封禁
    private double money; //店铺销售额
}
