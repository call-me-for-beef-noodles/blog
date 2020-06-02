package com.sec.blog.dao;/*
@author 杨鹏
@date 2020/4/28 - 16:22
*/

import com.sec.blog.po.Blog;
import com.sec.blog.po.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {
}
