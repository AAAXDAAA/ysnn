package com.ysnn.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ysnn.api.common.R;
import com.ysnn.api.entity.ImageUrlEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface ImageUrlEntityService extends IService<ImageUrlEntity> {
    R getImageUrl(MultipartFile file,int uid) throws IOException;
}
