package com.itdom.checkapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itdom.CheckApiApplication;
import com.itdom.checkapi.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checkApi")
public class CheckApiController {
    @Autowired
    ObjectMapper objectMapper;
    private static final Logger logger = LoggerFactory.getLogger(CheckApiController.class);
    @GetMapping("/getByPhone")
    public String getByPhone(@RequestParam("phone") String phone) {
        return "SUCCESS:" + phone;
    }
    @PostMapping("/addUser")
    public boolean addUser(@RequestBody @Validated @NonNull User user){
        try {
            logger.info("user info:{}", objectMapper.writeValueAsString(user));
            return true;
        } catch (JsonProcessingException e) {
            logger.debug("cause:{}",e.getMessage());
        }
        return false;
    }
}
