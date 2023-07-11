package com.ysnn.api.vo;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Data
public class ReadingNotesVo {
    private int uid;
    private String date;
    private String readnotes;
    private String bookname;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
