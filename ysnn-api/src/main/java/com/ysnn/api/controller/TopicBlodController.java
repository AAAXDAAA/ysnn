package com.ysnn.api.controller;


import com.ysnn.api.common.R;
import com.ysnn.api.entity.TopicSettingEntity;
import com.ysnn.api.service.BlodTopicEntityService;
import com.ysnn.api.service.TopicSettingEntityService;
import com.ysnn.api.vo.BlodTopicVo;
import com.ysnn.api.vo.GetTopicBlogListRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TopicBlodController {
    @Autowired
    private BlodTopicEntityService blodTopicEntityService;
    @Autowired
    private TopicSettingEntityService topicSettingEntityService;
    @PostMapping("/api/getTopicBlod/")
    public R getTopicBlod(@RequestBody BlodTopicVo blodTopicVo){
        return blodTopicEntityService.GetTopicBlod(blodTopicVo);
    }
    @PostMapping("/api/showTopicBlod/")
    public R showTopicBlod(@RequestBody Map<String,Object>body){
        String topic = (String) body.get("topic");
        int uid = (int) body.get("uid");
        return blodTopicEntityService.justshow(uid,topic);
    }
    @GetMapping("/api/getTopic")
    public R GetTopic(){
        return topicSettingEntityService.GetTopic();
    }


    @PostMapping("api/getTopicBlogList")
    public R getTopicBlogList(@RequestBody GetTopicBlogListRequest getTopicBlogListRequest){
        List<TopicSettingEntity> topics = getTopicBlogListRequest.getTopics();
        int page = getTopicBlogListRequest.getPage();
        int size = getTopicBlogListRequest.getSize();
        System.out.println(1);
        return blodTopicEntityService.GetTopicBlogList(topics,page,size);
    }


}
