package com.example.apigatewaydemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/fallback")
@Controller
public class FallbackController {

    @GetMapping("/message")
    public String fallback() throws InterruptedException {

        return "Resource Not Found";
    }

}
