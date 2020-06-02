package com.sec.blog.service;/*
@author 杨鹏
@date 2020/4/23 - 16:56
*/

import com.sec.blog.po.User;

public interface UserService {

    User checkUser(String username, String password);
}
