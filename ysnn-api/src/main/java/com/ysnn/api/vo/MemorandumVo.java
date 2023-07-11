package com.ysnn.api.vo;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.sql.Date;

@Data
public class MemorandumVo {
    private int uid;
    private String date;

    private String text;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}

