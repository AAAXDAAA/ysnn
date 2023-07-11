package com.ysnn.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysnn.api.common.R;
import com.ysnn.api.mapper.UserVoMapper;
import com.ysnn.api.service.UserVoService;
import com.ysnn.api.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserVoServiceImpl extends ServiceImpl<UserVoMapper, UserVo> implements UserVoService {
    @Autowired
    private UserVoMapper userVoMapper;

    @Override
    public R showUserInfo(){
        return R.success(null,userVoMapper.selectList(null));
    }

    @Override
    public R showUserInfoById(Integer uid) {
        QueryWrapper<UserVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid",uid);
        return R.success("用户基本信息",userVoMapper.selectList(queryWrapper));
    }


}

