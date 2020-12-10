package com.hunguigu.controller;

import com.hunguigu.service.ImgInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ImgInfoController {

    @Autowired
    ImgInfoService service;

}
