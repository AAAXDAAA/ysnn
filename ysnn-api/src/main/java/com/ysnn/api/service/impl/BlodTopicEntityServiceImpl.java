package com.ysnn.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysnn.api.common.R;
import com.ysnn.api.entity.BlodTopicEntity;
import com.ysnn.api.entity.DiaryEntity;
import com.ysnn.api.entity.TopicSettingEntity;
import com.ysnn.api.mapper.BlodTopicEntityMapper;
import com.ysnn.api.service.BlodTopicEntityService;
import com.ysnn.api.vo.BlodTopicVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlodTopicEntityServiceImpl extends ServiceImpl<BlodTopicEntityMapper, BlodTopicEntity> implements BlodTopicEntityService {
    @Autowired
    private BlodTopicEntityMapper blodTopicEntityMapper;

    @Override
    public R GetTopicBlod(BlodTopicVo blodTopicVo){
        BlodTopicEntity blodTopicEntity = new BlodTopicEntity();
        BeanUtils.copyProperties(blodTopicVo,blodTopicEntity);
        QueryWrapper<BlodTopicEntity> judgeWrapper = new QueryWrapper<>();
        judgeWrapper.eq("uid",blodTopicEntity.getUid());
        judgeWrapper.eq("date",blodTopicEntity.getDate());
        judgeWrapper.eq("topic",blodTopicEntity.getTopic());
        if (blodTopicEntityMapper.selectCount(judgeWrapper)>0){
            blodTopicEntityMapper.update(blodTopicEntity,judgeWrapper);
            return showBlodData("update",blodTopicEntity);
        }else {
            blodTopicEntityMapper.insert(blodTopicEntity);
            return showBlodData("insert",blodTopicEntity);
        }
    }
    @Override
    public  R showBlodData (String mes,BlodTopicEntity blodTopicEntity){
        QueryWrapper<BlodTopicEntity> showQuerywapper = new QueryWrapper<>();
        showQuerywapper.eq("uid",blodTopicEntity.getUid());
        showQuerywapper.eq("date",blodTopicEntity.getDate());
        showQuerywapper.eq("topic",blodTopicEntity.getTopic());
        return R.success(mes,blodTopicEntityMapper.selectList(showQuerywapper));
    }
    @Override
    public R justshow (int uid , String topic){
        BlodTopicEntity blodTopicEntity = new BlodTopicEntity();
        QueryWrapper<BlodTopicEntity> justShowWrapper = new QueryWrapper<>();
        justShowWrapper.eq("uid",uid);
        justShowWrapper.eq("topic",topic);
        if (blodTopicEntityMapper.selectCount(justShowWrapper)>0){
            return R.success("succse",blodTopicEntityMapper.selectList(justShowWrapper));
        }else {
            return R.error("null or error");
        }
    }

    @Override
    public R GetTopicBlogList(List<TopicSettingEntity> topics,int page,int size){
        List<BlodTopicEntity> BlogResult = new ArrayList<>();
        for (TopicSettingEntity topic : topics){
            String topicValue  = topic.getTopic();
            QueryWrapper<BlodTopicEntity> blodTopicEntityQueryWrapper = new QueryWrapper<>();
            blodTopicEntityQueryWrapper.eq("topic",topicValue);
            blodTopicEntityQueryWrapper.last("LIMIT "+size+" OFFSET " + (page-1)*size);
            List<BlodTopicEntity> tempResult = blodTopicEntityMapper.selectList(blodTopicEntityQueryWrapper);
            BlogResult.addAll(tempResult);
        }
        return R.success("success", BlogResult);
    }



}
