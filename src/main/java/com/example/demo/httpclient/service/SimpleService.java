package com.example.demo.httpclient.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Service
public interface SimpleService {

    Map<String,Object> getDocument(HttpServletRequest request);
}
