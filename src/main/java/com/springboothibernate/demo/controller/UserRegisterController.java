package com.springboothibernate.demo.controller;

import com.springboothibernate.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user")
public class UserRegisterController {
    @Autowired
    userService userService;


}
