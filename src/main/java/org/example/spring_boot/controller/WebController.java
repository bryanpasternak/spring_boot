package org.example.spring_boot.controller;

import org.example.spring_boot.common.Result;
import org.example.spring_boot.exception.CustomException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @GetMapping("/hello")
    public Result hello() {
        throw new CustomException("400","禁止访问");
    }

    @GetMapping("/error")
    public Result error(){
        throw new CustomException("400","禁止访问");
    }
}
