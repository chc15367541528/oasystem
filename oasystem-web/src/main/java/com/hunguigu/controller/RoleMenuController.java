package com.hunguigu.controller;

import com.hunguigu.service.RoleMenuService;
import com.hunguigu.vo.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/roleMenu")
public class RoleMenuController {

    @Autowired
    RoleMenuService roleMenuService;

    @RequestMapping("/queryAllRoleMenu.action")
    @ResponseBody
    @CrossOrigin
    public List<RoleMenu> queryAllRoleMenu(int rid){

        return roleMenuService.queryAllRoleMenu(rid);
    }

    //授权
    @RequestMapping("/author.action")
    @ResponseBody
    @CrossOrigin
    public String  author(@RequestParam(value = "menuids",defaultValue = "") String menuids,
                            @RequestParam(value = "roleid",defaultValue = "0")  int roleid){

        int num=roleMenuService.deleteRoleid(roleid);

        RoleMenu roleMenu=new RoleMenu();

        roleMenu.setRid(roleid);

        String[] mids = menuids.split(",");

        for(int i=0;i<mids.length;i++){
            try{
                roleMenu.setMid(Integer.valueOf(mids[i]));
            }catch (Exception e){
                System.out.println(e);
            }
            num=roleMenuService.addRM(roleMenu);
        }

        if(num==1){
            return "授权成功";
        }else{
            return "授权失败";
        }
    }
}
