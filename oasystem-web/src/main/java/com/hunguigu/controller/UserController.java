package com.hunguigu.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hunguigu.service.UserService;
import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.User;
import com.hunguigu.vo.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @ResponseBody
    @RequestMapping("/query.action")
    @CrossOrigin
    public String query(User user,
                        @RequestParam(value = "page",defaultValue = "1") int page,
                        @RequestParam(value = "rows",defaultValue = "10") int rows){

        PageVo<User> pagevo=service.query(user,page,rows);

        return JSONObject.toJSONString(pagevo, SerializerFeature.DisableCircularReferenceDetect);
    }

    @ResponseBody
    @RequestMapping("/add.action")
    @CrossOrigin
    public String add(User user){
        int rows=service.insert(user);

        return rows==1?"添加成功":"添加失败";
    }

    @ResponseBody
    @RequestMapping("delete.action")
    @CrossOrigin
    public String delete(int id){
        int rows=service.delete(id);

        return  rows==1?"删除成功":"删除失败";
    }

    @ResponseBody
    @RequestMapping("/update.action")
    @CrossOrigin
    public String update(User user){
        int rows=service.update(user);

        return rows==1?"修改成功":"修改失败";
    }

    @ResponseBody
    @RequestMapping("/queryById.action")
    @CrossOrigin
    public String queryById(int id){
        return JSONObject.toJSONString(service.queryById(id),SerializerFeature.DisableCircularReferenceDetect);
    }

    @ResponseBody
    @RequestMapping("/queryByName.action")
    @CrossOrigin
    public String queryByName(String username){
        return JSONObject.toJSONString(service.queryUserName(username),SerializerFeature.DisableCircularReferenceDetect);
    }

    //选择提货商户
    @ResponseBody
    @RequestMapping("/queryRole.action")
    @CrossOrigin
    public String queryRole(int rid){

        return JSONObject.toJSONString(service.queryRole(rid),SerializerFeature.DisableCircularReferenceDetect);
    }


}
