package com.hunguigu.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hunguigu.service.CommodityService;
import com.hunguigu.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    CommodityService service;

    @RequestMapping(value = "/query.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String query(Commodity commodity,
                        @RequestParam(value = "commodityType_id", defaultValue = "0") int commodityType_id,
                        @RequestParam(value = "brand_id", defaultValue = "0") int brand_id,
                        @RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "rows",defaultValue = "5") int rows){

        if(commodityType_id!=0){
            CommodityType commodityType = new CommodityType();
            commodity.setId(commodityType_id);
            commodity.setCommodityType(commodityType);
        }

        if(brand_id!=0){
            Brand brand = new Brand();
            brand.setId(brand_id);
            commodity.setBrand(brand);
        }

        return JSONObject.toJSONString(service.query(commodity,page,rows), SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/insert.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String insert(Commodity commodity){

        int row = service.insert(commodity);
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
    public String update(Commodity commodity){

        int row =service.update(commodity);
        String msg = row==1?"修改成功":"修改失败";

        return msg;

    }

    @RequestMapping(value = "/queryById.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String querybyid(@RequestParam(value = "id", defaultValue = "1")int id){

        return JSONObject.toJSONString(service.queryById(id), SerializerFeature.DisableCircularReferenceDetect);

    }
}
