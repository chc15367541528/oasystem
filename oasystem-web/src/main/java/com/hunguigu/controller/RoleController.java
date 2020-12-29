package com.hunguigu.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hunguigu.service.RoleService;
import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService service;

    @RequestMapping("/queryfenpeirole.action")
    @ResponseBody
    @CrossOrigin
    public List<Role> queryFenPeiRole(){
        return service.queryFenPeiRole();
    }

    @RequestMapping(value = "/queryAll.action", produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String queryAll() {
        return JSONObject.toJSONString(service.queryAll(), SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/query.action", produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String queryTotal(Role role,
                             @RequestParam(value = "page", defaultValue = "1") int page,
                             @RequestParam(value = "rows", defaultValue = "5") int rows) {
        PageVo<Role> pageVo = service.query(role, page, rows);
        return JSONObject.toJSONString(pageVo, SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/queryById.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String queryById(@RequestParam(value = "id", defaultValue = "1")int id){

        return JSONObject.toJSONString(service.queryById(id), SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/insert.action", produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String insert(Role role) {

        int row = service.insert(role);
        String msg = row != 0 ? "添加成功" : "添加失败";

        return msg;
    }

    @RequestMapping(value = "/delete.action", produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String delete(String ids) {
        String[] idList = ids.split(",");
        int rows = 0;
        for (int i = 0; i < idList.length; i++) {
            rows += service.delete(Integer.parseInt(idList[i]));
        }
        String msg = rows != 0 ? "删除成功" : "删除失败";

        return msg;
    }

    @RequestMapping(value = "/update.action", produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String update(Role role) {

        int row = service.update(role);
        String msg = row!=0?"修改成功" : "修改失败";
        return msg;
    }
}
