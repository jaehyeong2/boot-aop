package com.high.mvc2.cookie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CookieController {

    @GetMapping("/")
    public String home(){
        return "home";
    }
}
