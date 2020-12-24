package com.hunguigu.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hunguigu.service.ColorInfoService;
import com.hunguigu.vo.Brand;
import com.hunguigu.vo.ColorInfo;
import com.hunguigu.vo.Commodity;
import com.hunguigu.vo.CommodityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/colorInfo")
public class ColorInfoController {

    @Autowired
    ColorInfoService service;

    @RequestMapping(value = "/query.action", produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String query(ColorInfo colorInfo,
                        @RequestParam(value = "commodity_id", defaultValue = "0") int commodity_id,
                        @RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "rows", defaultValue = "5") int rows) {
        if (commodity_id != 0) {
            Commodity commodity = new Commodity();
            commodity.setId(commodity_id);
            colorInfo.setCommodity(commodity);
        }

        return JSONObject.toJSONString(service.query(colorInfo, page, rows), SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/queryAll.action")
    @ResponseBody
    @CrossOrigin
    public List<ColorInfo> queryAll(ColorInfo colorInfo,
                                    @RequestParam(value = "commodity_id", defaultValue = "0") int commodity_id) {
        if (commodity_id != 0) {
            Commodity commodity = new Commodity();
            commodity.setId(commodity_id);
            colorInfo.setCommodity(commodity);
        }
        //return JSONObject.toJSONString(service.queryAll(colorInfo), SerializerFeature.DisableCircularReferenceDetect);
        return service.queryAll(colorInfo);
    }

    @RequestMapping(value = "/insert.action", produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String insert(ColorInfo colorInfo,
                         @RequestParam(value = "commodity_id", defaultValue = "0") int commodity_id) {
        if (commodity_id != 0) {
            Commodity commodity = new Commodity();
            commodity.setId(commodity_id);
            colorInfo.setCommodity(commodity);
        }

        int row = service.insert(colorInfo);
        String msg = row == 1 ? "添加成功" : "添加失败";

        return msg;
    }

    @RequestMapping(value = "/delete.action", produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String delete(String ids) {

        String[] idList = ids.split(",");
        int rows = 0;
        for (int i = 0; i < idList.length; i++) {
            rows += service.delete(Integer.parseInt(idList[i]));
        }
        String msg = rows == idList.length ? "删除成功" : "删除失败";

        return msg;

    }

    @RequestMapping(value = "/update.action", produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String update(ColorInfo colorInfo,
                         @RequestParam(value = "commodity_id", defaultValue = "0") int commodity_id) {
        if (commodity_id != 0) {
            Commodity commodity = new Commodity();
            commodity.setId(commodity_id);
            colorInfo.setCommodity(commodity);
        }

        int row = service.update(colorInfo);
        String msg = row == 1 ? "修改成功" : "修改失败";

        return msg;

    }

    @RequestMapping(value = "/queryById.action", produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String queryById(@RequestParam(value = "id", defaultValue = "0") int id) {

        return JSONObject.toJSONString(service.queryById(id), SerializerFeature.DisableCircularReferenceDetect);

    }

}
