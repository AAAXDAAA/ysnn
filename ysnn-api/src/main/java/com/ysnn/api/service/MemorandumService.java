package com.ysnn.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ysnn.api.common.R;
import com.ysnn.api.entity.MemorandumEntity;
import com.ysnn.api.vo.MemorandumVo;

public interface MemorandumService extends IService<MemorandumEntity> {
    R getMemorandumEntityData(MemorandumVo memorandumVo);
    R showMemorandumEntityData(String mes,MemorandumEntity memorandumEntity);
    R justShowMemorandumEntityData(int uid,String date);
}
