package com.sec.blog.service;/*
@author 杨鹏
@date 2020/4/23 - 16:58
*/

import com.sec.blog.dao.UserRepository;
import com.sec.blog.po.User;
import com.sec.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
