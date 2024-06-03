package com.example.kurumsalweb.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {
    
    @RequestMapping("/error")
    public String handleError() {
        // 404 hatası durumunda yönlendirilecek sayfa
        return "404ErrorPage.html";
    }
    
    public String getErrorPath() {
        return "/error";
    }
}