package com.hunguigu.controller;

import com.hunguigu.service.MenuService;
import com.hunguigu.service.RoleMenuService;
import com.hunguigu.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @Autowired
    RoleMenuService roleMenuService;

    //通过条件查询所有
    @RequestMapping("/querymenucount.action")
    @ResponseBody
    @CrossOrigin
    public PageVo<Menu> queryMenuCount(Menu menu,
                                       @RequestParam(value = "page", defaultValue = "1") int page,
                                       @RequestParam(value = "rows", defaultValue = "10") int rows){
        return menuService.queryMenuCount(menu,page,rows);
    }

    //通过父id查询数据
    @RequestMapping("/querybypid.action")
    @ResponseBody
    @CrossOrigin
    public List<Menu> queryByPid(){
        return menuService.queryByPid();
    }


    //查询左边菜单
    @RequestMapping("/queryAllLeftMenu.action")
    @ResponseBody
    @CrossOrigin
    public List<Menu> queryAllLeftMenu(int sid){

        return menuService.queryAllLeftMenu(sid);
    }

    //查询授权菜单
    @RequestMapping("/queryAuthorMenu.action")
    @ResponseBody
    @CrossOrigin
    public List<Menu> queryAuthorMenu(Integer staid){
//        System.out.println(staid);
        return menuService.queryAuthorMenu(staid);
    }
}
