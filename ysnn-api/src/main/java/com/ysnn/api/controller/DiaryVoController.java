package com.ysnn.api.controller;


import com.ysnn.api.common.R;
import com.ysnn.api.service.DiaryEntityService;
import com.ysnn.api.vo.DiaryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DiaryVoController {
    @Autowired
    private DiaryEntityService diaryEntityService;
    @PostMapping("/api/diaryDataChange")
    public R  diaryDataChange(@RequestBody DiaryVo diaryVo){
//        System.out.println(diaryVo);
//        System.out.println(diaryVo.getDiary());
        return diaryEntityService.getDiaryEntityData(diaryVo);
    }

    @PostMapping("/api/showDiaryData")
    public R justShowDiaryData(@RequestBody Map<String,Object>body){
        String date = (String) body.get("date");
        int uid = (int) body.get("uid");
//        System.out.println(body);
        return diaryEntityService.justShowDiaryData(uid,date);
    }
}
