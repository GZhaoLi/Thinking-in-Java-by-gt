package com.gui.demo.controller;

import com.gui.demo.domain.NbaPlayer;
import com.gui.demo.service.NbaPlayerService;
import com.gui.demo.service.impl.NbaPlayerServiceImpl;
import com.gui.demo.utils.RedisUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Resource
    private RedisUtils redisUtils;
    @Resource
    private NbaPlayerServiceImpl nbaPlayerService;

    @RequestMapping("setAndGet")
    public String test(String k, String v){
        redisUtils.set(k, v);
        return (String) redisUtils.get(k);
    }
    @RequestMapping("test")
    public Object test(){
        return NbaPlayerService.ListNbaPlayer();
    }

    @PostMapping("/ss")
    public List<NbaPlayer> nbaPlayer() {
        return nbaPlayerService.ListNbaPlayer();
    }
}
