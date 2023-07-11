package com.ysnn.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.sql.Date;

@Data
@TableName(value = "memorandum")
public class MemorandumEntity {
    private int uid;
    private String date;

    private String text;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
