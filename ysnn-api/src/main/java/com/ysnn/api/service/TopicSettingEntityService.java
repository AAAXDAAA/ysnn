package com.ysnn.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ysnn.api.common.R;
import com.ysnn.api.entity.TopicSettingEntity;

public interface TopicSettingEntityService extends IService<TopicSettingEntity> {
    R GetTopic();
}
