package com.hunguigu.controller;

import com.hunguigu.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PurchaseController {

    @Autowired
    PurchaseService service;

}
