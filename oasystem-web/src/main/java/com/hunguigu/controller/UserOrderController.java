package com.hunguigu.controller;

import com.hunguigu.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserOrderController {

    @Autowired
    UserOrderService service;

}
