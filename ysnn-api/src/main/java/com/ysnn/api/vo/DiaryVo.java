package com.ysnn.api.vo;


import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Date;

@Data
public class DiaryVo {
    private int uid;


    private String date;

    @Lob
    @Column(columnDefinition = "text")
    private String diary;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
