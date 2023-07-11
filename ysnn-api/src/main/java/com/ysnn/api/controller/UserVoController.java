package com.ysnn.api.controller;


import com.ysnn.api.common.R;
import com.ysnn.api.service.UserEntityService;
import com.ysnn.api.service.UserVoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserVoController {
    @Autowired
    private UserVoService userVoService;

    @GetMapping("/api/")
    public R showUserInfo(){
        return userVoService.showUserInfo();
    }

    @GetMapping("api/2")
    public R showUserInfoById(@RequestParam int uid){
        return userVoService.showUserInfoById(uid);
    }

    }



