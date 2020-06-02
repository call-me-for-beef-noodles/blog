package com.sec.blog.dao;/*
@author 杨鹏
@date 2020/4/28 - 15:29
*/

import com.sec.blog.po.Tag;
import com.sec.blog.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {

    Tag findByName(String name);
}
