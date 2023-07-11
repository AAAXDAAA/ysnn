package com.ysnn.api.vo;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Data
public class BlodTopicVo {
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
