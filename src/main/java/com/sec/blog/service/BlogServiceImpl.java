package com.sec.blog.service;/*
@author 杨鹏
@date 2020/4/28 - 16:21
*/

import com.sec.blog.dao.BlogRepository;
import com.sec.blog.po.Blog;
import com.sec.blog.po.Type;
import javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
class BlogServiceImpl implements BlogService {


    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog getBlog(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Blog> listBlog(Pageable pageable, Blog blog) {

        return blogRepository.findAll(new Specification<Blog>() {
                                          @Override
                                          public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                                              List<Predicate> predicates = new ArrayList<>();
                                              if ("".equals(blog.getTitle()) && blog.getTitle() != null) {
                                                  predicates.add(cb.like(root.<String>get("title"), "%" + blog.getTitle() + "%"));
                                              }
                                              if (blog.getType().getId() != null) {
                                                  predicates.add(cb.equal(root.<Type>get("type").get("id"), blog.getType().getId()));
                                              }
                                              if (blog.isRecommend()) {
                                                  predicates.add(cb.equal(root.<Boolean>get("recommend"), blog.isRecommend()));
                                              }
                                              cq.where(predicates.toArray(new Predicate[predicates.size()]));
                                              return null;
                                          }
                                      }
                , pageable);
    }

    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog updateBlog(Long id, Blog blog) {
        Blog blog1 = blogRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(blog, blog1);
        return blogRepository.save(blog1);
    }

    @Override
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}
