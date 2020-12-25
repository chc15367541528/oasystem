package com.hunguigu.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hunguigu.service.RoleService;
import com.hunguigu.service.StaffService;
import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.Staff;
import com.hunguigu.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    StaffService service;
    @Autowired
    RoleService roleService;


    @RequestMapping(value = "/login.action")
    @ResponseBody
    @CrossOrigin
    public Map login(Staff staff,
                     HttpSession session){
        Map<String,String> map =new HashMap<String,String>();
        Staff staff1= service.staffDengLu(staff);

        if(staff1!=null){
            session.setAttribute("staff",staff1);

            map.put("code","0");
            map.put("msg","登录成功");
            map.put("account",staff1.getAccount());
        }else{
            map.put("code","1");
            map.put("msg","登录失败");
        }
        return map;
    }

    @RequestMapping(value = "/query.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String queryTotal(Staff staff,
                                    @RequestParam(value = "page", defaultValue = "1")int page,
                                    @RequestParam(value = "rows", defaultValue = "5")int rows){
        PageVo<Staff> pageVo = service.query(staff, page, rows);
        return JSONObject.toJSONString(pageVo, SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/queryAll.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String queryAll(){
        return JSONObject.toJSONString(service.queryAll(), SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/queryById.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String queryById(@RequestParam(value = "id", defaultValue = "1")int id){

        return JSONObject.toJSONString(service.queryById(id), SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/insert.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String insert(Staff staff,
                         @RequestParam(value = "role_id",defaultValue = "0")int role_id){
        if(role_id!=0){
            staff.setRole(roleService.queryById(role_id));
        }
        int row = service.insert(staff);
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
            rows+=service.delete(Integer.parseInt(idList[i]));
        }
        String msg = rows==idList.length?"删除成功":"删除失败";

        return msg;

    }

    @RequestMapping(value = "/update.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String update(Staff staff,
                         @RequestParam(value = "role_id", defaultValue = "0")int role_id){
        if(role_id != 0){
            staff.setRole(roleService.queryById(role_id));
        }
        int row = service.update(staff);
        String msg = row==1?"修改成功":"修改失败";

        return msg;

    }
}
