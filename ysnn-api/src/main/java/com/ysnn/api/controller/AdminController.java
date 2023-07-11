package com.ysnn.api.controller;


import com.ysnn.api.common.R;
import com.ysnn.api.entity.UserInfo;
import com.ysnn.api.service.UserEntityService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.Map;


@RestController
public class AdminController {
    @Autowired
    private UserEntityService userEntityService;

    @PostMapping("/api/dologin")
    public R headleLogin(@RequestBody Map<String, Object> body, HttpSession session) {
        String useraccount = (String) body.get("useraccount");
        String usercode = (String) body.get("usercode");
        System.out.println(useraccount);
        System.out.println(usercode);
        return userEntityService.heandleLogin(useraccount, usercode, session);
    }
    @PostMapping("/api/doRegistry")
    public R doRegistry(@RequestBody UserInfo userInfo){
        return userEntityService.doRegistry(userInfo);
    }


}
