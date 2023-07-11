package com.ysnn.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysnn.api.entity.UserInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityMapper extends BaseMapper<UserInfo> {
}
