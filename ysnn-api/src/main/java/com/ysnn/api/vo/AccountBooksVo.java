package com.ysnn.api.vo;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Data
public class AccountBooksVo {
    private int    uid;
    private String date;
    private float  income;
    private float  pay;
    private String  incomedetails;
    private String  paydetails;
    private float   mouthincome;
    private float   mouthpay;
    private float   mouthtatol;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
