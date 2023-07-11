package com.ysnn.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ysnn.api.common.R;
import com.ysnn.api.entity.PomodoroEntity;
import com.ysnn.api.vo.PomodoroVo;

public interface PomodoroEntityService extends IService<PomodoroEntity> {
    R getPomodoroData(PomodoroVo pomodoroVo);
    R ShowPomodoroData(String mes,PomodoroEntity pomodoroEntity);
    R justShowPodomoroData(String todaydate,int uid);


}
