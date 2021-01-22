package com.springboothibernate.demo.service.impl;

import com.springboothibernate.demo.repository.UserRepository;
import com.springboothibernate.demo.service.userService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class userServiceImpl implements userService {
    @Resource
    UserRepository userRepository;
}
