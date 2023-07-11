package com.ysnn.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.sql.Date;

@Data
@TableName(value = "reading_notes")
public class ReadingNotesEntity {
    private int uid;
    private String date;
    private String readnotes;
    private String bookname;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
