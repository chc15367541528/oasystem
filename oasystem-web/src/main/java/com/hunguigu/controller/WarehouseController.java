package com.hunguigu.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hunguigu.service.WarehouseService;
import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.ShoppingCart;
import com.hunguigu.vo.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;

    @RequestMapping(value = "/query.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String query(Warehouse warehouse,
                        @RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "rows",defaultValue = "5") int rows){

        PageVo<Warehouse> pagevo= warehouseService.query(warehouse,page,rows);
        return JSONObject.toJSONString(pagevo, SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/insert.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String insert(Warehouse warehouse){

        int row = warehouseService.insert(warehouse);
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
            rows+=warehouseService.delete(Integer.parseInt(idList[i]));
        }
        String msg = rows==idList.length?"删除成功":"删除失败";

        return msg;

    }

    @RequestMapping(value = "/update.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String update(Warehouse warehouse){

        int row = warehouseService.update(warehouse);
        String msg = row==1?"修改成功":"修改失败";

        return msg;

    }

    @RequestMapping(value = "/queryById.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String querybyid(@RequestParam(value = "id", defaultValue = "1")int id){

        return JSONObject.toJSONString(warehouseService.queryById(id), SerializerFeature.DisableCircularReferenceDetect);

    }
}
