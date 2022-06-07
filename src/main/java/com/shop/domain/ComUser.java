package com.shop.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Blob;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("comuser")
public class ComUser {
    private String comuserPhone;
    private String comuserName;
    private String comuserMail;
    private String comuserCity;
    private String comuserGender;
    private String comuserBankaccount;
    private String comuserNickname;
    private String comuserPassword;
    private String comuserInformation;
    private String comuserWechat;
    private Double comuserBalance;
    private String comuserAddress;
    private String comuserImage;
    private Integer comuserLevel; //0->普通用户 1->管理员 2->待审核用户 3->被封号的用户 管理员只能进行管理
    private Double comuserMoney;
}
