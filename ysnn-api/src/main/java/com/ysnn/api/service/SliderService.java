package com.ysnn.api.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ysnn.api.common.R;
import com.ysnn.api.entity.SliderEntity;

public interface SliderService extends IService<SliderEntity> {
    R GetWordById(int id);
    R SetWordById(int id , String word);

}
