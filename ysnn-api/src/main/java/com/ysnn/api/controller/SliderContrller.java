package com.ysnn.api.controller;

import com.ysnn.api.common.R;
import com.ysnn.api.service.SliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class SliderContrller {
    @Autowired
    SliderService sliderService;
    @GetMapping("/api/GetSlider")
    public R GetSlider(@RequestParam("id") int id){
        return sliderService.GetWordById(id);
    }
    @PostMapping("api/SetSlider")
public R SetSlider(@RequestBody Map<String,Object> body){
    String word= (String) body.get("word");
        int id = Integer.parseInt((String) body.get("id"));
    return sliderService.SetWordById(id,word);
}
}
