package com.shop.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("bill")
public class Bill {
    private Integer id;
    private String userphone;
    private double money;
    private Integer orders;
    private Integer bian; //0->充值 1->付款
    private String time;
}
