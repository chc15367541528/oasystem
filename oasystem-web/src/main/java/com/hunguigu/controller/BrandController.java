package com.hunguigu.controller;

import com.hunguigu.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BrandController {

    @Autowired
    BrandService service;
}
