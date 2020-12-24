package com.hunguigu.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hunguigu.service.VersionInfoService;
import com.hunguigu.vo.Brand;
import com.hunguigu.vo.Commodity;
import com.hunguigu.vo.CommodityType;
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
@RequestMapping("/versionInfo")
public class VersionInfoController {

    @Autowired
    VersionInfoService service;

    @RequestMapping(value = "/query.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String query(VersionInfo versionInfo,
                        @RequestParam(value = "commodity_id", defaultValue = "0") int commodity_id,
                        @RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "rows",defaultValue = "5") int rows){

        if (commodity_id != 0) {
            Commodity commodity = new Commodity();
            commodity.setId(commodity_id);
            versionInfo.setCommodity(commodity);
        }

        return JSONObject.toJSONString(service.query(versionInfo,page,rows), SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/queryAll.action")
    @ResponseBody
    @CrossOrigin
    public List<VersionInfo> queryAll(VersionInfo versionInfo,
                         @RequestParam(value = "commodity_id", defaultValue = "0") int commodity_id){
        if (commodity_id != 0) {
            Commodity commodity = new Commodity();
            commodity.setId(commodity_id);
            versionInfo.setCommodity(commodity);
        }
        return service.queryAll(versionInfo);
    }
    @RequestMapping(value = "/queryById.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String queryById(@RequestParam(value = "id", defaultValue = "0")int id){

        return JSONObject.toJSONString(service.queryById(id), SerializerFeature.DisableCircularReferenceDetect);

    }
    @RequestMapping(value = "/queryByCommodityId.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String queryByCommodityId(@RequestParam(value = "id", defaultValue = "0")int id){

        return JSONObject.toJSONString(service.queryByCommodityId(id), SerializerFeature.DisableCircularReferenceDetect);

    }

    @RequestMapping(value = "/insert.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String insert(VersionInfo versionInfo,
                         @RequestParam(value = "brand_id", defaultValue = "0") int brand_id,
                         @RequestParam(value = "file",required = false) MultipartFile img) throws IOException {

        int row = service.insert(versionInfo);
        String msg = row==1?"添加成功":"添加失败";

        return msg;

    }

    @RequestMapping(value = "/delete.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String delete(String ids){

        String[] idList = ids.split(",");
        int rows = 0;
        for(int i=0;i<idList.length;i++){
            rows+=service.delete(Integer.parseInt(idList[i]));
        }
        String msg = rows==idList.length?"删除成功":"删除失败";

        return msg;

    }

    @RequestMapping(value = "/update.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String update(VersionInfo versionInfo,
                         @RequestParam(value = "brand_id", defaultValue = "0") int brand_id,
                         @RequestParam(value = "file",required = false) MultipartFile img) throws IOException {

        int row =service.update(versionInfo);
        String msg = row==1?"修改成功":"修改失败";
        return msg;
    }



}
