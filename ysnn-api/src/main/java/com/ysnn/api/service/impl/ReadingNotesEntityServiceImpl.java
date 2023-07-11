package com.ysnn.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysnn.api.common.R;
import com.ysnn.api.entity.AccountsBookEntity;
import com.ysnn.api.entity.ReadingNotesEntity;
import com.ysnn.api.mapper.ReadingNotesEntityMapper;
import com.ysnn.api.service.ReadingNotesService;
import com.ysnn.api.vo.ReadingNotesVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadingNotesEntityServiceImpl extends ServiceImpl<ReadingNotesEntityMapper, ReadingNotesEntity> implements ReadingNotesService {
    @Autowired
    private ReadingNotesEntityMapper readingNotesEntityMapper;

    @Override
    public R getNotesData(ReadingNotesVo readingNotesVo){
        ReadingNotesEntity readingNotesEntity = new ReadingNotesEntity();
        BeanUtils.copyProperties(readingNotesVo,readingNotesEntity);
        QueryWrapper<ReadingNotesEntity> judgeWrapper = new QueryWrapper<>();
        judgeWrapper.eq("uid",readingNotesEntity.getUid());
        judgeWrapper.eq("date",readingNotesEntity.getDate());
        judgeWrapper.eq("readnotes",readingNotesEntity.getReadnotes());

        if (readingNotesEntityMapper.selectCount(judgeWrapper)>0){
            readingNotesEntityMapper.update(readingNotesEntity,judgeWrapper);
            return showData("update",readingNotesEntity );
        }else{
            readingNotesEntityMapper.insert(readingNotesEntity);
            return showData("Insert",readingNotesEntity );
        }
    }

    @Override
    public R justShowData(int uid,String date,String bookname){

        ReadingNotesEntity readingNotesEntity = new ReadingNotesEntity();
        QueryWrapper<ReadingNotesEntity> justShowDateQueryWrapper = new QueryWrapper<>();
        justShowDateQueryWrapper.eq("uid",uid);
        justShowDateQueryWrapper.eq("date",date);
        justShowDateQueryWrapper.eq("bookname",bookname);
        if (readingNotesEntityMapper.selectCount(justShowDateQueryWrapper)>0){
            return R.success("succse",readingNotesEntityMapper.selectList(justShowDateQueryWrapper));
        }else {
            return R.error("null or error");
        }
    }

    @Override
    public  R showData (String mes,  ReadingNotesEntity readingNotesEntity ){
        QueryWrapper< ReadingNotesEntity> showQuerywapper = new QueryWrapper<>();
        showQuerywapper.eq("uid",readingNotesEntity.getUid());
        showQuerywapper.eq("date",readingNotesEntity.getDate());
        return R.success(mes,readingNotesEntityMapper.selectList(showQuerywapper));
    }

    @Override
    public R showNoteListByBookName(int uid , String bookname){
        QueryWrapper<ReadingNotesEntity> judgeWrapper = new QueryWrapper<>();
        judgeWrapper.eq("bookname",bookname);
        judgeWrapper.eq("uid",uid);
        judgeWrapper.orderByDesc("date");
        return  R.success("success",readingNotesEntityMapper.selectList(judgeWrapper));
    }


    @Override
    public R getBookNameList(int uid){
        QueryWrapper<ReadingNotesEntity> getBooksWrapper = new QueryWrapper<>();
        getBooksWrapper.eq("uid",uid);
        if ( readingNotesEntityMapper.selectCount(getBooksWrapper)>0){
            return R.success("success", readingNotesEntityMapper.selectList(getBooksWrapper));
        }else {
            return R.error("null");
        }
    }

}
