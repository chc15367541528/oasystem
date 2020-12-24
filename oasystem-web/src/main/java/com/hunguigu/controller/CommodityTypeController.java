package com.hunguigu.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hunguigu.service.CommodityTypeService;
import com.hunguigu.vo.CommodityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/commodityType")
public class CommodityTypeController {

    @Autowired
    CommodityTypeService service;

    @RequestMapping("/query.action")
    @ResponseBody
    @CrossOrigin
    public String query(CommodityType commodityType,
                        @RequestParam(value = "page",defaultValue = "1") int page,
                        @RequestParam(value = "rows",defaultValue = "5")int rows){
        return JSONObject.toJSONString(service.query(commodityType,page,rows), SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping("/add.action")
    @ResponseBody
    @CrossOrigin
    public String insert(CommodityType commodityType){
        int row=service.insert(commodityType);
        return row>0?"添加成功":"添加失败";
    }

    @RequestMapping("/delete.action")
    @ResponseBody
    @CrossOrigin
    public String delete(String ids){
        String[] idss = ids.split(",");

        for (int i=0;i<idss.length;i++){
            service.delete(Integer.parseInt(idss[i]));
        }

        return "删除成功！";
    }

    @RequestMapping("/update.action")
    @ResponseBody
    @CrossOrigin
    public String update(CommodityType commodityType){
        int row=service.update(commodityType);
        return row>0?"修改成功":"修改失败";
    }

    @RequestMapping("/queryById.action")
    @ResponseBody
    @CrossOrigin
    public String queryById(int id){
        return JSONObject.toJSONString(service.queryById(id), SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping("/queryAll.action")
    @ResponseBody
    @CrossOrigin
    public String queryAll(){

        return JSONObject.toJSONString(service.queryAll(), SerializerFeature.DisableCircularReferenceDetect);

    }
}
