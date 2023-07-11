package com.ysnn.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysnn.api.common.R;
import com.ysnn.api.entity.DiaryEntity;
import com.ysnn.api.mapper.DiaryEntityMapper;
import com.ysnn.api.service.DiaryEntityService;
import com.ysnn.api.vo.DiaryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaryEntityServiceImpl extends ServiceImpl<DiaryEntityMapper, DiaryEntity> implements DiaryEntityService {
    @Autowired
    private DiaryEntityMapper diaryEntityMapper;
    @Override
    public R getDiaryEntityData(DiaryVo diaryVo){
       DiaryEntity diaryEntity = new DiaryEntity();
        BeanUtils.copyProperties(diaryVo,diaryEntity);
        QueryWrapper<DiaryEntity> judgeQueryWrapper =  new QueryWrapper<>();
        judgeQueryWrapper.eq("uid",diaryEntity.getUid());
        judgeQueryWrapper.eq("date",diaryEntity.getDate());
        if (diaryEntityMapper.selectCount(judgeQueryWrapper)>0){
            diaryEntityMapper.update(diaryEntity,judgeQueryWrapper);
            return showDiaryData("update",diaryEntity);
        }else{
            diaryEntityMapper.insert(diaryEntity);
            return showDiaryData("insert",diaryEntity);
        }
    }

    @Override
    public  R showDiaryData (String mes,DiaryEntity diaryEntity){
        QueryWrapper<DiaryEntity> showQuerywapper = new QueryWrapper<>();
        showQuerywapper.eq("uid",diaryEntity.getUid());
        showQuerywapper.eq("date",diaryEntity.getDate());
        return R.success(mes,diaryEntityMapper.selectList(showQuerywapper));
    }

    @Override
    public  R justShowDiaryData(int uid,String data){
        DiaryEntity diaryEntity = new DiaryEntity();
        QueryWrapper<DiaryEntity> justShowDiardateQuerWrapper = new QueryWrapper<>();
        justShowDiardateQuerWrapper.eq("uid",uid);
        justShowDiardateQuerWrapper.eq("date",data);
        if (diaryEntityMapper.selectCount(justShowDiardateQuerWrapper)>0){
            return R.success("succse",diaryEntityMapper.selectList(justShowDiardateQuerWrapper));
        }else {
            return R.error("null or error");
        }
    }


}
