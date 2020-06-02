package com.sec.blog.dao;/*
@author 杨鹏
@date 2020/4/26 - 14:42
*/

import com.sec.blog.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {

    Type findByName(String name);
}
