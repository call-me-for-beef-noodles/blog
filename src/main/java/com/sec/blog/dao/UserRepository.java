package com.sec.blog.dao;/*
@author 杨鹏
@date 2020/4/23 - 16:59
*/

import com.sec.blog.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);
}
