package com.shop.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("platform")
public class Platform {
    private Integer id;
    private Integer sumuser;
    private Integer sumbusiness;
    private Integer sumorder;
    private Integer sumcommodity;
    private Double tempmoney;
    private Double profit;
}
