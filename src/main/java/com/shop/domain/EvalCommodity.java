package com.shop.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("evalcommodity")
public class EvalCommodity {
    private Integer id;
    private Integer commodityid;
    private String commodityname;
    private String businessname;
    private String businessid;
    private String content;
    private Integer score;
    private String userphone;
}
