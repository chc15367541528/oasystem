package com.hunguigu.controller;

import com.hunguigu.service.MenuService;
import com.hunguigu.vo.MenuInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService service;

    //查询出所有的菜单信息(菜单显示用，有层级关系)
    @RequestMapping("/queryAllMenus.action")
    @ResponseBody
    @CrossOrigin
    public List<MenuInfo> queryallmenus(){

        return  service.queryAllMenus(2,0);
    }

    //查询出所有的菜单信息(授权页面用，显示到按钮级别)
    //2020-10-12修改
    @RequestMapping("/queryAllMenus2.action")
    @ResponseBody
    @CrossOrigin
    public List<MenuInfo> queryallmenus2(int rid){

        return  service.queryAllMenus(3,rid);
    }

    @RequestMapping(value = "/auth.action",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String authSave(
            @RequestParam(value = "menuids",defaultValue = "")String[] mids,
            @RequestParam(value = "roleid",defaultValue = "0")  int roleid){
        System.out.println("roleid:"+roleid);
        System.out.println("mids:");

        for (String id :mids ) {
            System.out.print(id+",");
        }
        return "授权成功";
    }
}
