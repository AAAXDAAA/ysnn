package com.ysnn.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "slider")
public class SliderEntity {
    private int id;
    private String word;
    private String url;
    private String title;
}
