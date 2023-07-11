package com.ysnn.api.controller;

import com.ysnn.api.common.R;
import com.ysnn.api.service.ImageUrlEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class GetImageUrlController {
    @Autowired
    private ImageUrlEntityService imageUrlEntityService;
    @PostMapping("/api/getImageUrl")
    public R getImageUrl(@RequestParam("file") MultipartFile file, @RequestParam("uid") int uid) throws IOException {
        return imageUrlEntityService.getImageUrl(file, uid);
    }

}
