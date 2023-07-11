package com.ysnn.api.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.sql.Date;

@Data
@TableName(value = "pomodoro_time")
public class PomodoroEntity {
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
