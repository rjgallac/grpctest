package com.example.demo.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("hello")
@RestController
public class HelloController {


    @Autowired
    private HelloWorldClient helloWorldClient;

    @GetMapping
    public void get(){
        helloWorldClient.sayHello("bob", "g");
    }
}
