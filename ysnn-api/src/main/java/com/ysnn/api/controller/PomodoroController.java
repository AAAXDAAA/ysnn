package com.ysnn.api.controller;


import com.ysnn.api.common.R;
import com.ysnn.api.service.PomodoroEntityService;
import com.ysnn.api.vo.PomodoroVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PomodoroController {
    @Autowired
    private PomodoroEntityService pomodoroEntityService;
    @PostMapping("/api/podomoroDataChange")
    public R podomoroDataChange(@RequestBody PomodoroVo pomodoroVo){
        System.out.println(pomodoroVo);
//        System.out.println(pomodoroVo.getTodaydate());
        return pomodoroEntityService.getPomodoroData(pomodoroVo);

    }
    @PostMapping("/api/showPodomoroData")
    public R showPodomoroData(@RequestBody Map<String,Object> boby){
        String todaydate= (String) boby.get("todaydate");
        int uid = (int) boby.get("uid");
        System.out.println(uid);
        System.out.println(todaydate);
        return pomodoroEntityService.justShowPodomoroData(todaydate,uid);
    }
}
