package com.ysnn.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ysnn.api.common.R;
import com.ysnn.api.entity.BlodTopicEntity;
import com.ysnn.api.entity.TopicSettingEntity;
import com.ysnn.api.vo.BlodTopicVo;

import java.util.List;

public interface BlodTopicEntityService extends IService<BlodTopicEntity> {
    R GetTopicBlod(BlodTopicVo blodTopicVo);
    R showBlodData (String mes,BlodTopicEntity blodTopicEntity);
    R justshow (int uid , String topic);
    R GetTopicBlogList(List<TopicSettingEntity> topics,int page,int size);
}
