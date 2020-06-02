package com.sec.blog.web;/*
@author 杨鹏
@date 2020/4/20 - 0:57
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class IndexController {


    @RequestMapping("/")
    public String aa() {
        System.out.println("------------login----------");
        return "index";
    }

}
