package com.datasource.demo.controller;

import com.datasource.demo.entity.User;
import com.datasource.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Wu Zicong
 * @create 2022-03-09 10:07
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private DemoService demoService;

    @GetMapping("/getUserInfo")
    public String getUserInfo(String id){
        User userInfo = demoService.getUserInfo(id);
        return userInfo.toString();
    }
    @PostMapping("/insertUser")
    public String insertUser(){
        User user = new User("1002", "mike", 0);
        Integer integer = demoService.insertUser(user);
        return integer.toString();
    }
    @PostMapping("/updateUser")
    public String updateUser(){
        User user = new User("1001", "mike", 0);
        Integer integer = demoService.updateUser(user);
        return integer.toString();
    }
}
