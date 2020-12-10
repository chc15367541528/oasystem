package com.hunguigu.controller;

import com.hunguigu.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ShoppingCartController {

    @Autowired
    ShoppingCartService service;

}
