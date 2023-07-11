package com.ysnn.api.vo;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Data
public class ImageUrlVo {
    private int uid;
    private String imageurl;
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
