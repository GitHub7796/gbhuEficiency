package com.example.Eficiency.controller;

import com.example.Eficiency.service.BannerSerive;
import com.example.Eficiency.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/banner")
public class BannerController {
    @Autowired
    private BannerSerive bannerSerive;

    @GetMapping("list")
    public JsonData list() {
        return JsonData.buildSuccess(bannerSerive.list());
    }
}
