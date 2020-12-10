package com.hunguigu.controller;

import com.hunguigu.service.WarehouseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class WarehouseDetailController {

    @Autowired
    WarehouseDetailsService service;

}
