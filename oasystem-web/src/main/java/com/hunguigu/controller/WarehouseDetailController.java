package com.hunguigu.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hunguigu.service.WarehouseDetailsService;
import com.hunguigu.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

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

    @RequestMapping(value = "/insert.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String insert(WarehouseDetails warehouseDetails,
                         @RequestParam(value = "commodity_id", defaultValue = "0") int commodity_id,
                         @RequestParam(value = "warehouse_id", defaultValue = "0") int warehouse_id) throws IOException {

        if(commodity_id!=0){
            Commodity commodity = new Commodity();
            commodity.setId(commodity_id);
            warehouseDetails.setCommodity(commodity);
        }

        if(warehouse_id!=0){
            Warehouse warehouse = new Warehouse();
            warehouse.setId(warehouse_id);
            warehouseDetails.setWarehouse(warehouse);
        }
        int row = service.insert(warehouseDetails);
        String msg = row==1?"添加成功":"添加失败";

        return msg;

    }

    @RequestMapping(value = "/update.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String insert(WarehouseDetails warehouseDetails) throws IOException {

        int row = service.update(warehouseDetails);
        String msg = row==1?"修改成功":"修改失败";

        return msg;

    }

    @RequestMapping(value = "/updateByComAndWarehouse.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String updateByComAndWarehouse(WarehouseDetails warehouseDetails,
                                        @RequestParam(value = "commodity_id", defaultValue = "0") int commodity_id,
                                        @RequestParam(value = "warehouse_id", defaultValue = "0") int warehouse_id) throws IOException {

        if(commodity_id!=0){
            Commodity commodity = new Commodity();
            commodity.setId(commodity_id);
            warehouseDetails.setCommodity(commodity);
        }

        if(warehouse_id!=0){
            Warehouse warehouse = new Warehouse();
            warehouse.setId(warehouse_id);
            warehouseDetails.setWarehouse(warehouse);
        }

        int row = service.updateByComAndWarehouse(warehouseDetails);
        String msg = row==1?"修改成功":"修改失败";

        return msg;

    }

}
