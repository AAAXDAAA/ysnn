package com.ysnn.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysnn.api.common.R;
import com.ysnn.api.entity.SliderEntity;
import com.ysnn.api.mapper.SliderEntityMapper;
import com.ysnn.api.service.SliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SliderServiceImpl extends ServiceImpl<SliderEntityMapper, SliderEntity> implements SliderService {
    @Autowired
    SliderEntityMapper sliderEntityMapper;

    @Override
    public R GetWordById(int id){
        SliderEntity sliderEntity = new SliderEntity();
        QueryWrapper<SliderEntity> q = new QueryWrapper<>();
        q.eq("id",id);
        return R.success("msg1", sliderEntityMapper.selectList(q));
    }
    @Override
    public R SetWordById(int id , String word){
        SliderEntity sliderEntity = new SliderEntity();
        QueryWrapper<SliderEntity> q = new QueryWrapper<>();
        sliderEntity.setWord(word);
        sliderEntity.setId(id);
        q.eq("id",id);
        if (sliderEntityMapper.selectCount(q)>0){
            sliderEntityMapper.update(sliderEntity,q);
        }else {
            sliderEntityMapper.insert(sliderEntity);
    }
        return R.success("save");
    }
}
