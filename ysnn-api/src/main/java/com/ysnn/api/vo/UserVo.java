package com.ysnn.api.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

@TableName(value = "user_info")

@Data
public class UserVo implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer uid;
    private String username;
    private Integer nameid;
    private String avatarurl;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}