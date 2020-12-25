package com.hunguigu.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hunguigu.service.UserOrderService;
import com.hunguigu.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/userOrder")
public class UserOrderController {

    @Autowired
    UserOrderService service;

    @RequestMapping(value = "/query.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String queryAll(UserOrder userOrder,
                           @RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "rows",defaultValue = "1000") int rows,
                           @RequestParam(value = "user_id", defaultValue = "0") int user_id,
                           @RequestParam(value = "merchants_id", defaultValue = "0") int merchants_id){

        if(merchants_id!=0){
            User merchants = new User();
            merchants.setId(merchants_id);
            userOrder.setMerchants(merchants);
        }
        if(user_id!=0){
            User user = new User();
            user.setId(user_id);
            userOrder.setUser(user);
        }
        return JSONObject.toJSONString(service.query(userOrder, page, rows), SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/queryByState.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String  queryByState(int state){
        return JSONObject.toJSONString(service.queryByState(state),SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/update.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String  update(UserOrder userOrder){
        int row = service.update(userOrder);
        return row==1?"发货成功":"发货失败";
    }
    @RequestMapping(value = "/insert.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String insert(UserOrder userOrder,
                         @RequestParam(value = "user_id", defaultValue = "0") int user_id,
                         @RequestParam(value = "merchants_id", defaultValue = "0") int merchants_id,
                         @RequestParam(value = "commodity_id", defaultValue = "0") int commodity_id) throws IOException {

        if(user_id!=0){
            User user = new User();
            user.setId(user_id);
            userOrder.setUser(user);
        }

        if(merchants_id!=0){
            User user = new User();
            user.setId(merchants_id);
            userOrder.setMerchants(user);
        }

        if(commodity_id!=0){
            Commodity commodity = new Commodity();
            commodity.setId(commodity_id);
            userOrder.setCommodity(commodity);
        }

        //设置订单创建时间
        userOrder.setCreatetime(new Date());

        int row = service.insert(userOrder);
        String msg = row==1?"添加成功":"添加失败";

        return msg;

    }

    /**
     * 根据订单号查询订单
     * @param order_number
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/queryByOrderNumber.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String insert(@RequestParam(value = "order_number", defaultValue = "0")String order_number) throws IOException {

        UserOrder userOrder = new UserOrder();
        userOrder.setOrder_number(order_number);

        return JSONObject.toJSONString(service.query(userOrder,1,5).getRows().get(0), SerializerFeature.DisableCircularReferenceDetect);

    }

}
