package com.example.demo.httpclient.controller;

import com.example.demo.httpclient.service.SimpleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequestMapping("/simple/v1")
public class SimpleController {
    private final Logger log = LoggerFactory.getLogger(SimpleController.class);

    @Resource
    SimpleService service;

    @PostMapping("/document")
    public Map<String, Object> getDocument(HttpServletRequest request) {
        return service.getDocument(request);
    }
}
