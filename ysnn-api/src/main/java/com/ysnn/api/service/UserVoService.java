package com.ysnn.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ysnn.api.common.R;
import com.ysnn.api.vo.UserVo;

public interface UserVoService extends IService<UserVo> {
    R showUserInfo();
    R showUserInfoById(Integer uid);
}
