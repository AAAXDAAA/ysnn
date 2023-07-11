package com.ysnn.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysnn.api.common.R;
import com.ysnn.api.entity.PomodoroEntity;
import com.ysnn.api.mapper.PomodoroEntityMapper;
import com.ysnn.api.service.PomodoroEntityService;
import com.ysnn.api.vo.PomodoroVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PomodoroEntityServiceImpl extends ServiceImpl<PomodoroEntityMapper, PomodoroEntity> implements PomodoroEntityService {
    @Autowired
    private PomodoroEntityMapper pomodoroEntityMapper;

    @Override
    public R getPomodoroData(PomodoroVo pomodoroVo){
        PomodoroEntity pomodoroEntity = new PomodoroEntity();
        BeanUtils.copyProperties(pomodoroVo,pomodoroEntity);
        QueryWrapper<PomodoroEntity> judgeQueryWrapper = new QueryWrapper<>();
        judgeQueryWrapper.eq("uid",pomodoroEntity.getUid());
        judgeQueryWrapper.eq("todaydate",pomodoroEntity.getTodaydate());
        /**
         * 该位置后负责计算total的值
          */
        QueryWrapper<PomodoroEntity> totalQueryWrapper = new QueryWrapper<>();
        totalQueryWrapper.eq("uid",pomodoroEntity.getUid());
        totalQueryWrapper.orderByDesc("total");
        totalQueryWrapper.last("LIMIT 1");
        PomodoroEntity result = pomodoroEntityMapper.selectOne(totalQueryWrapper);
        int i=pomodoroVo.getToday()-result.getToday();
        pomodoroEntity.setTotal(result.getTotal()+i);
        if (pomodoroEntityMapper.selectCount(judgeQueryWrapper)>0){
            pomodoroEntityMapper.update(pomodoroEntity,judgeQueryWrapper);
            return ShowPomodoroData("update",pomodoroEntity);
        }else {
            pomodoroEntityMapper.insert(pomodoroEntity);
            return ShowPomodoroData("Insert",pomodoroEntity);
        }
    }
    @Override
     public R justShowPodomoroData(String todaydate,int uid){
        PomodoroEntity pomodoroEntity = new PomodoroEntity();
        QueryWrapper<PomodoroEntity> judgeQueryWrapper = new QueryWrapper<>();
        judgeQueryWrapper.eq("uid",uid);
        judgeQueryWrapper.eq("todaydate",todaydate);

        if (pomodoroEntityMapper.selectCount(judgeQueryWrapper)>0){
            return R.success("succse",pomodoroEntityMapper.selectList(judgeQueryWrapper));
        }else {
            return R.error("null or error");
        }
    }

    @Override
    public R ShowPomodoroData(String mes,PomodoroEntity pomodoroEntity){
        QueryWrapper<PomodoroEntity> showQueryWrapper = new QueryWrapper<>();
        showQueryWrapper.eq("uid",pomodoroEntity.getUid());
        showQueryWrapper.eq("todaydate",pomodoroEntity.getTodaydate());
        return R.success(mes,pomodoroEntityMapper.selectList(showQueryWrapper));
    }






}
