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

import java.io.File;
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

    @RequestMapping(value = "/insert.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String insert(ImgInfo imgInfo,
                         @RequestParam(value = "commodity_id", defaultValue = "0") int commodity_id,
                         @RequestParam(value = "file",required = false) MultipartFile img) throws IOException {

        if(commodity_id!=0){
            Commodity commodity = new Commodity();
            commodity.setId(commodity_id);
            imgInfo.setCommodity(commodity);
        }

        if(img!=null){
            imgInfo.setImg(img.getOriginalFilename());  //保存到数据库的【相对路径】
            //将上传的文件保存到服务器上的前端项目的【绝对路径】
            /*img.transferTo(new File("D:\\S3\\project-web\\oasystem-web\\src\\assets\\"+img.getOriginalFilename()));*/
        }


        int row = service.insert(imgInfo);
        String msg = row==1?"添加成功":"添加失败";

        return msg;

    }
}
