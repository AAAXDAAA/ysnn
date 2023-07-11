package com.ysnn.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysnn.api.common.R;
import com.ysnn.api.entity.UserInfo;
import com.ysnn.api.mapper.UserEntityMapper;
import com.ysnn.api.service.UserEntityService;
import com.ysnn.api.service.UserVoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


@Service
public class UseEntityServiceImpl  extends ServiceImpl<UserEntityMapper, UserInfo> implements UserEntityService {
    @Autowired
    private UserEntityMapper userEntityMapper;
    @Autowired
    private UserVoService userVoService;

    @Override
    public R heandleLogin(String useraccount, String usercode, HttpSession httpSession) {
        QueryWrapper<UserInfo> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("useraccount",useraccount);
        queryWrapper.eq("usercode",usercode);
        if (userEntityMapper.selectCount(queryWrapper)>0){
            UserInfo userInfo=userEntityMapper.selectOne(queryWrapper);
            Integer uid = userInfo.getUid();
            httpSession.setAttribute("uid",uid);
            return userVoService.showUserInfoById(uid);
        }
        return R.error("账户或密码错误");
    }

    @Override
    public R doRegistry(UserInfo userInfo){
        if (this.isEmailExist(userInfo.getEmail())){
            return R.warning("该邮箱已被使用");
        }
        if (this.isUseraccountExist(userInfo.getUseraccount())){
            return R.warning("账号已被注册");
        }


        userInfo.setNameid(userInfo.getUid()+1);
        //Todo usercode加密
        //例子： String password = DigestUtils.md5DigestAsHex((SALT + registryRequest.getPassword()).getBytes(StandardCharsets.UTF_8));

        try {

            if (userEntityMapper.insert(userInfo)>0){
                return R.success("注册成功");
            }else {
                return R.success("注册失败");
            }
        }catch (DuplicateKeyException e){
            return R.fatal(e.getMessage());
        }



    }

    @Override
    public boolean isUseraccountExist(String useraccount){
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("useraccount",useraccount);
        return userEntityMapper.selectCount(queryWrapper)>0;
    }
    @Override
    public boolean isEmailExist(String email){
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email",email);
        return userEntityMapper.selectCount(queryWrapper)>0;
    }



}
