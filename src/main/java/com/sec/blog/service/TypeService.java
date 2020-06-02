package com.sec.blog.service;/*
@author 杨鹏
@date 2020/4/26 - 14:38
*/

import com.sec.blog.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TypeService {

    Type saveType(Type type);

    Type getType(Long id);

    Page<Type> listType(Pageable pageable);

    Type updateType(Long id, Type type);

    void deleteType(Long id);

    Type getTypeByName(String name);
}
