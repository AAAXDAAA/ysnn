package com.ysnn.api.vo;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

@Data
public class PomodoroVo {
    private int uid;
    private int littletomato;
    private int today;

   private String todaydate;
    private int total;
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }

}
