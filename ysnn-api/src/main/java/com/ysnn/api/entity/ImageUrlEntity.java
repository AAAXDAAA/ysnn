package com.ysnn.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Data
@TableName(value="imageurl")
public class ImageUrlEntity {
    private int uid;
    private String imageurl;
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
