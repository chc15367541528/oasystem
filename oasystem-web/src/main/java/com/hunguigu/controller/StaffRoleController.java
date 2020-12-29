package com.hunguigu.controller;

import com.hunguigu.service.StaffRoleService;
import com.hunguigu.vo.StaffRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/staffRole")
public class StaffRoleController {

    @Autowired
    StaffRoleService staffRoleService;

    //通过员工id查询拥有的 角色 选中的角色
    @RequestMapping("/queryAllStaffRole.action")
    @ResponseBody
    @CrossOrigin
    public List<StaffRole> queryAllStaffRole(int staffid){

        return staffRoleService.queryAllStaffRole(staffid);
    }

    //分配
    @RequestMapping("/fenpei.action")
    @ResponseBody
    @CrossOrigin
    public String  FenPei(@RequestParam(value = "roleids",defaultValue = "") String roleids,
                          @RequestParam(value = "staffid",defaultValue = "0")  int staffid){

        int num=staffRoleService.deleteStaffid(staffid);

        StaffRole staffRole=new StaffRole();

        staffRole.setStaffid(staffid);

        String[] rids = roleids.split(",");

        for(int i=0;i<rids.length;i++){
            try{
                staffRole.setRoleid(Integer.valueOf(rids[i]));
            }catch (Exception e){
                System.out.println(e);
            }
            num=staffRoleService.addSR(staffRole);
        }

        if(num==1){
            return "分配成功";
        }else{
            return "分配失败";
        }
    }
}
