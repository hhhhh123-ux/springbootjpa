package com.springboothibernate.demo.security;


import com.springboothibernate.demo.entiy.User;
import com.springboothibernate.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (null == s || "".equals(s)) {
            throw new RuntimeException("用户不能为空");
        }
        User user = userRepository.selectByname(s);
        System.out.println(user);

        return new User(user.getId(), user.getName(), user.getPassword());
    }
}
