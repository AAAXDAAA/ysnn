package com.ysnn.api.vo;

import com.ysnn.api.entity.TopicSettingEntity;
import lombok.Data;

import java.util.List;

@Data
public class GetTopicBlogListRequest {
    private List<TopicSettingEntity> topics;
    private int page;
    private int size;
}
