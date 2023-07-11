package com.ysnn.api.controller;


import com.ysnn.api.common.R;
import com.ysnn.api.service.AccountsBookEntityService;
import com.ysnn.api.vo.AccountBooksVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AccountsBooksController {
    @Autowired
    private AccountsBookEntityService accountsBookEntityService;
    @PostMapping("/api/AccountsDataChange")
    public R AccountsDataChange(@RequestBody AccountBooksVo accountBooksVo){
        System.out.println(accountBooksVo);
        return accountsBookEntityService.getAcountsData(accountBooksVo);
    }

    @PostMapping("/api/justShowAccountsDate")
    public R justShowAccountsDate(@RequestBody Map<String,Object>body){
        String date = (String) body.get("date");
        int uid = (int)body.get("uid");
        System.out.println(body);
        return accountsBookEntityService.justShowData(uid,date);
    }
}
