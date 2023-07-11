package com.ysnn.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.extern.java.Log;
import lombok.extern.jbosslog.JBossLog;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Lob;
import java.sql.Date;

@Data
@TableName(value ="accoutsbook")
public class AccountsBookEntity {
    private int uid;
    private String date;
    private float income;
    private float pay;

    private String incomedetails;
    private String paydetails;
    private float mouthincome;
    private float mouthpay;
    private float mouthtatol;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }

}
