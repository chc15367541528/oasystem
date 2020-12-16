package com.hunguigu.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hunguigu.service.ShoppingCartService;
import com.hunguigu.service.UserService;
import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
