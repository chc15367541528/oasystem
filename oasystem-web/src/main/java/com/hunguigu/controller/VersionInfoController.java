package com.hunguigu.controller;

import com.hunguigu.service.VersionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class VersionInfoController {

    @Autowired
    VersionInfoService service;

}
