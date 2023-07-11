package com.ysnn.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Data
@TableName(value = "settopic")
public class TopicSettingEntity {
    private String topic;
    private String date;
    private String adminname;
    private int isuse;
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
