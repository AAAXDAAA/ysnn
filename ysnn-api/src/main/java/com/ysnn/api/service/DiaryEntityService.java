package com.ysnn.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ysnn.api.common.R;
import com.ysnn.api.entity.DiaryEntity;
import com.ysnn.api.vo.DiaryVo;

public interface DiaryEntityService extends IService<DiaryEntity> {
      R getDiaryEntityData(DiaryVo diaryVo);
      R showDiaryData(String mes,DiaryEntity diaryEntity);
      R justShowDiaryData(int uid,String data);
}
