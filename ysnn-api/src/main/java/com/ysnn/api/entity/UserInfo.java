package com.ysnn.api.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

@Data

@TableName(value = "user_info")
public class UserInfo implements Serializable {
    @TableId(value = "uid",type = IdType.AUTO)
    private int uid;
    private String useraccount;
//    @TableId(value = "nameid",type = IdType.AUTO)
    private  int nameid;
    private String username;
    private String usercode;
    private String email;
    private String avatarurl;
    @Override
public String toString(){return ToStringBuilder.reflectionToString(this);
    }
}
