package com.itdom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkApi")
public class CheckApiController {

    @GetMapping("/getByPhone")
    public String getByPhone(@RequestParam("phone") String phone) {
        return "SUCCESS:" + phone;
    }

}
