package com.hunguigu.controller;

import com.hunguigu.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CommodityController {

    @Autowired
    CommodityService service;
}
