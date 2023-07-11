package com.ysnn.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysnn.api.common.R;
import com.ysnn.api.entity.TopicSettingEntity;
import com.ysnn.api.mapper.TopicSettingEntityMapper;
import com.ysnn.api.service.BlodTopicEntityService;
import com.ysnn.api.service.TopicSettingEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.List;

@Service
public class TopicSettingEntityServiceImpl extends ServiceImpl<TopicSettingEntityMapper, TopicSettingEntity> implements TopicSettingEntityService {
    @Autowired
    private TopicSettingEntityMapper topicSettingEntityMapper;
    @Autowired
    private BlodTopicEntityService blodTopicEntityService;
    @Override
    public R GetTopic(){
        int isuse =1;
        QueryWrapper<TopicSettingEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("isuse",isuse);
        return R.success("topic",topicSettingEntityMapper.selectList(queryWrapper));
    }

}
