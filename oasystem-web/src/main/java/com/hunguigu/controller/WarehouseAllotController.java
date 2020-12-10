package com.hunguigu.controller;

import com.hunguigu.service.WarehouseAllotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class WarehouseAllotController {

    @Autowired
    WarehouseAllotService service;

}
