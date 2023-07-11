package com.ysnn.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ysnn.api.common.R;
import com.ysnn.api.entity.UserInfo;

import javax.servlet.http.HttpSession;

public interface UserEntityService extends IService<UserInfo> {
    R heandleLogin(String useraccount, String usercode, HttpSession httpSession);
    R doRegistry(UserInfo userInfo);
    boolean isUseraccountExist(String useraccount);
    boolean isEmailExist(String email);
}
