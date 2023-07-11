package com.ysnn.api.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysnn.api.common.R;
import com.ysnn.api.entity.ImageUrlEntity;
import com.ysnn.api.mapper.ImageUrlEntityMapper;
import com.ysnn.api.service.ImageUrlEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class ImageUrlEntityServiceImpl extends ServiceImpl<ImageUrlEntityMapper, ImageUrlEntity> implements ImageUrlEntityService {
    @Autowired
    private ImageUrlEntityMapper imageUrlEntityMapper;
    @Override
    public R getImageUrl(MultipartFile file,int uid) throws IOException {
        String FileUploadPath = "D:\\ysnn\\images\\";
        String originalFilename = file.getOriginalFilename();
        String type = FileUtil.extName(originalFilename);
        String fileUUID = IdUtil.fastSimpleUUID() + StrUtil.DOT + type;
        File uploadFile = new File(FileUploadPath+fileUUID);
        File parentFile = uploadFile.getParentFile();
        if (!parentFile.exists()){
            parentFile.mkdirs();
        }
        String url;
        file.transferTo(uploadFile);
        url="http://localhost:8084/images/"+fileUUID;
        ImageUrlEntity imageUrlEntity = new ImageUrlEntity();
        imageUrlEntity.setUid(uid);
        imageUrlEntity.setImageurl(url);
        imageUrlEntityMapper.insert(imageUrlEntity);
        return R.success(url);
    }


}
