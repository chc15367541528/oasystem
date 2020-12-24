package com.hunguigu.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hunguigu.service.ShoppingCartService;
import com.hunguigu.service.UserService;
import com.hunguigu.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/shoppingCar")
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/query.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String query(ShoppingCart shoppingCart,
                        @RequestParam(value = "user_id", defaultValue = "0") int user_id,
                        @RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "rows",defaultValue = "1000") int rows){

        if(user_id!=0){
            shoppingCart.setUser(userService.queryById(user_id));
        }
        PageVo<ShoppingCart> pagevo= shoppingCartService.query(shoppingCart,page,rows);
        System.out.println(pagevo);
        return JSONObject.toJSONString(pagevo,SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/insert.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String insert(ShoppingCart shoppingCart,
                         @RequestParam(value = "user_id", defaultValue = "0") int user_id,
                         @RequestParam(value = "commodity_id", defaultValue = "0") int commodity_id,
                         @RequestParam(value = "color_id", defaultValue = "0") int color_id,
                         @RequestParam(value = "version_id", defaultValue = "0") int version_id) {

        if (user_id != 0) {
            User user = new User();
            user.setId(user_id);
            shoppingCart.setUser(user);
        }
        if (commodity_id != 0) {
            Commodity commodity = new Commodity();
            commodity.setId(commodity_id);
            shoppingCart.setCommodity(commodity);
        }
        if (color_id != 0) {
            ColorInfo colorInfo = new ColorInfo();
            colorInfo.setId(color_id);
            shoppingCart.setColorInfo(colorInfo);
        }
        if (version_id != 0) {
            VersionInfo versionInfo = new VersionInfo();
            versionInfo.setId(version_id);
            shoppingCart.setVersionInfo(versionInfo);
        }

        int row = shoppingCartService.insert(shoppingCart);
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
            rows+=shoppingCartService.delete(Integer.parseInt(idList[i]));
        }
        String msg = rows==idList.length?"删除成功":"删除失败";

        return msg;

    }

}
