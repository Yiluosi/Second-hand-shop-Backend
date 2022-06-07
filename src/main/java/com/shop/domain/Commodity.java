package com.shop.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("commodity")
public class Commodity {
    private Integer id;
    private String name;
    private Double price;
    private String category;
    private String information;
    private Integer stock;  // 库存
    private Integer sales;  // 历史销量
    private Integer score; //总评分
    private Integer flag; // 是否在卖 0->不在 1->在买
    private String business; // 商家
    private String busname; // 商家名称
    private String image; //图片

}
