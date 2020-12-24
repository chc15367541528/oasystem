package com.hunguigu.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hunguigu.service.ImgInfoService;
import com.hunguigu.vo.Commodity;
import com.hunguigu.vo.ImgInfo;
import com.hunguigu.vo.VersionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/imgInfo")
public class ImgInfoController {

    @Autowired
    ImgInfoService service;

    @RequestMapping(value = "/query.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String query(ImgInfo imgInfo,
                        @RequestParam(value = "commodity_id", defaultValue = "0") int commodity_id,
                        @RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "rows",defaultValue = "5") int rows){

        if (commodity_id != 0) {
            Commodity commodity = new Commodity();
            commodity.setId(commodity_id);
            imgInfo.setCommodity(commodity);
        }

        return JSONObject.toJSONString(service.query(imgInfo,page,rows), SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/queryAll.action")
    @ResponseBody
    @CrossOrigin
    public List<ImgInfo> queryAll(ImgInfo imgInfo,
                                      @RequestParam(value = "commodity_id", defaultValue = "0") int commodity_id){
        if (commodity_id != 0) {
            Commodity commodity = new Commodity();
            commodity.setId(commodity_id);
            imgInfo.setCommodity(commodity);
        }
        return service.queryAll(imgInfo);
    }
    @RequestMapping(value = "/queryById.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String queryById(@RequestParam(value = "id", defaultValue = "0")int id){

        return JSONObject.toJSONString(service.queryById(id), SerializerFeature.DisableCircularReferenceDetect);

    }

}
