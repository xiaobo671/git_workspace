package com.ist.springbootdemo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("hello")
    public String hello() {
        return "Hello this is my first springboot demo";
    }

    @RequestMapping("hehehe")
    public  String hello2(){
        return "springBoot测试";
    }
}
