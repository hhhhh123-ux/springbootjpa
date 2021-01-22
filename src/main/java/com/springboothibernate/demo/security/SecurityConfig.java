package com.springboothibernate.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@Configuration // 声明配置类
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    accessFailureHandler accessFailureHandler;

    @Resource
    CustomizeAuthenticationEntryPoint authenticationEntryPoint;

    @Resource
    LoginSuccessHandler loginSuccessHandler;

    @Resource
    LoginFailureHandler loginFailureHandler;

    @Resource
    logoutSuccessHandler logoutSuccessHandler;

    @Resource
    UserDetailsServiceImpl userDetailsService;

    /**
     * 设置加密方式
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 用户认证
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();//禁用跨站csrf攻击防御，后面的章节会专门讲解
        http.authorizeRequests()
                .antMatchers("/login")
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessFailureHandler)
                .authenticationEntryPoint(authenticationEntryPoint)
                .and().authorizeRequests().anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailureHandler)
                .permitAll()
                .and()
                .logout()
                .logoutSuccessHandler(logoutSuccessHandler);
        // session配置
        http.sessionManagement()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(false);
    }


}
