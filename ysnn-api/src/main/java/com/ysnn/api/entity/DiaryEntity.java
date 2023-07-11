package com.ysnn.api.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Date;

@Data
@TableName(value = "diary")
public class DiaryEntity {
    private int uid;
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private String date;

    @Lob
    @Column(columnDefinition = "text")
    private String diary;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
