package com.hunguigu.controller;

import com.hunguigu.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StaffController {

    @Autowired
    StaffService service;
}
