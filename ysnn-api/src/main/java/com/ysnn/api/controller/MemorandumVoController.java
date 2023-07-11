package com.ysnn.api.controller;

import com.ysnn.api.common.R;
import com.ysnn.api.service.MemorandumService;
import com.ysnn.api.vo.MemorandumVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MemorandumVoController {
    @Autowired
    private MemorandumService memorandumService;
    @PostMapping("/api/memorandumDataChange")
    public R getMemorandumEntityData(@RequestBody MemorandumVo memorandumVo){
        System.out.println(memorandumVo);
        System.out.println(memorandumVo.getDate());
        System.out.println(memorandumVo.getText());
        return memorandumService.getMemorandumEntityData(memorandumVo);
    }

    @PostMapping("/api/showMemorandumData")
    public R showMemorandumData(@RequestBody Map<String,Object> body){
        String date = (String) body.get("date");
        int uid = (int)body.get("uid");
        System.out.println(body);
        return memorandumService.justShowMemorandumEntityData(uid,date);
    }
}
