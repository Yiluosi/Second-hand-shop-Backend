package com.shop.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("cart")
public class Cart {
    public Integer id;
    public String userphone;
    public Integer commodityid;
    public Integer number;

    @TableField(exist = false)
    public String commodityname;
    @TableField(exist = false)
    public double price;
    @TableField(exist = false)
    public String image;
}
