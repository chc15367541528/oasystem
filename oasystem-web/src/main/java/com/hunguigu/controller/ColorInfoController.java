package com.hunguigu.controller;

import com.hunguigu.service.ColorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ColorInfoController {

    @Autowired
    ColorInfoService service;

}
