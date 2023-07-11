package com.ysnn.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ysnn.api.common.R;
import com.ysnn.api.entity.ReadingNotesEntity;
import com.ysnn.api.vo.ReadingNotesVo;

public interface ReadingNotesService extends IService<ReadingNotesEntity> {
    R getNotesData(ReadingNotesVo readingNotesVo);
    R justShowData(int uid,String date,String bookname);
    R showData (String mes,  ReadingNotesEntity readingNotesEntity );
    R showNoteListByBookName(int uid , String bookname);
    R getBookNameList(int uid);
}
