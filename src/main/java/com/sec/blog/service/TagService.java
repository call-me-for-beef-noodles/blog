package com.sec.blog.service;/*
@author 杨鹏
@date 2020/4/28 - 15:25
*/

import com.sec.blog.po.Tag;
import com.sec.blog.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TagService {

    Tag saveTag(Tag tag);

    Tag getTag(Long id);

    Page<Tag> listTag(Pageable pageable);

    Tag updateTag(Long id, Tag tag);

    void deleteTag(Long id);

    Tag getTagByName(String name);
}
