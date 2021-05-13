package com.gui.demo.controller;

import com.gui.demo.service.NbaPlayerService;
import com.gui.demo.service.impl.NbaPlayerServiceImpl;
import com.gui.demo.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private NbaPlayerService nbaPlayerService;

    @RequestMapping("setAndGet")
    public String test(String k, String v){
        redisUtils.set(k, v);
        return (String) redisUtils.get(k);
    }
    @RequestMapping("test")
    public Object test(){
        return NbaPlayerService.ListNbaPlayer();
    }
}
