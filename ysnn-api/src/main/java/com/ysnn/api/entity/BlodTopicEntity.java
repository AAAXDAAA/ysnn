package com.ysnn.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Data
@TableName(value ="topicblod")
public class BlodTopicEntity {
    private int uid;
    private String topic;
    private String contant;
    private int loves;
    private String date;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }

}
