package com.springboothibernate.demo.repository;

import com.springboothibernate.demo.entiy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value = "select * from user where name=?")
    User selectByname(String name);
}
