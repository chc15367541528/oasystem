package com.hunguigu.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hunguigu.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    BrandService service;

    @RequestMapping("/queryAll.action")
    @ResponseBody
    @CrossOrigin
    public String queryAll(){

        return JSONObject.toJSONString(service.queryAll(), SerializerFeature.DisableCircularReferenceDetect);

    }
}
