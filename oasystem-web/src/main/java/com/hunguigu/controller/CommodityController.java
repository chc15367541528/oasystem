package com.hunguigu.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hunguigu.service.CommodityService;
import com.hunguigu.vo.Commodity;
import com.hunguigu.vo.PageVo;
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

    @RequestMapping("/query.action")
    @ResponseBody
    @CrossOrigin
    public PageVo<Commodity> query(Commodity commodity,
                                   @RequestParam(value = "page",defaultValue = "1") int page,
                                   @RequestParam(value = "rows",defaultValue = "10") int rows){
        System.out.println("进入控制层");

        PageVo<Commodity> pageVo=service.query(commodity,page,rows);
        System.out.println(pageVo.toString());

        return service.query(commodity,page,rows);
    }


    @RequestMapping("/add.action")
    @ResponseBody
    @CrossOrigin
    public String add(Commodity commodity){
        int row=service.insert(commodity);

        return row==1?"添加成功":"添加失败";
    }

    @RequestMapping("/delete.action")
    @ResponseBody
    @CrossOrigin
    public String delete(int  id){
        int row=service.delete(id);
        return row==1?"删除成功":"删除失败";
    }

    @RequestMapping("/update.action")
    @ResponseBody
    @CrossOrigin
    public String update(Commodity commodity){
        int row=service.update(commodity);

        return row==1?"修改成功":"修改加失败";
    }

    @RequestMapping("/queryById.action")
    @ResponseBody
    @CrossOrigin
    public String queryById(int  id){

        return JSONObject.toJSONString(service.queryById(id), SerializerFeature.DisableCircularReferenceDetect);
    }
}
