package com.hunguigu.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hunguigu.service.WarehouseDetailsService;
import com.hunguigu.vo.Commodity;
import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.Warehouse;
import com.hunguigu.vo.WarehouseDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/warehouseDetail")
public class WarehouseDetailController {

    @Autowired
    WarehouseDetailsService service;

    @RequestMapping(value = "/query.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String query(WarehouseDetails warehouseDetails,
                        @RequestParam(value = "warehouse_id", defaultValue = "0") int warehouse_id,
                        @RequestParam(value = "commodity_name", defaultValue = "") String commodity_name,
                        @RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "rows",defaultValue = "5") int rows){

        if(warehouse_id!=0){
            Warehouse warehouse = new Warehouse();
            warehouse.setId(warehouse_id);
            warehouseDetails.setWarehouse(warehouse);
        }

        if(commodity_name!=""){
            Commodity commodity = new Commodity();
            commodity.setName(commodity_name);
            warehouseDetails.setCommodity(commodity);
        }

        return JSONObject.toJSONString(service.query(warehouseDetails,page,rows), SerializerFeature.DisableCircularReferenceDetect);
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

    @RequestMapping(value = "/queryComByWarehouseId.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String queryComByWarehouseId(@RequestParam(value = "warehouse_id", defaultValue = "0") int warehouse_id){

        return JSONObject.toJSONString(service.queryComByWarehouseId(warehouse_id), SerializerFeature.DisableCircularReferenceDetect);
    }

}
