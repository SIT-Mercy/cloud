package com.gallifrey.mercyhouse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("Hello/{name}")
    public String Hello(@PathVariable("name") String name,
    @RequestParam(value = "age",required = false)  int age
    ){
        return "Hello "+name+age;
    }
}
