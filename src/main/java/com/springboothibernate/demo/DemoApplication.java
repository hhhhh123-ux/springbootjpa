package com.springboothibernate.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@MapperScan(basePackages = {"com.springboothibernate.demo","com.springboothibernate.demo.security"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        test(args);
    }



     public static void test(String[] args){
         BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println( passwordEncoder.encode("123456"));

     }
}
