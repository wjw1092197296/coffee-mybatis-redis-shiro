package com.my.coffee.dao;

import com.my.coffee.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * @Auther: wangjw
 * @Date: 2019/8/21 15:39
 * @Description:
 */
@Mapper
public interface UserDao  {

/*
    @Cacheable(cacheNames = "0830",key = "#p0")
    User findByName(String name);
*/

    @Cacheable(cacheNames = "0830",key = "#p0")
    User findById(Integer id);
    @CachePut(cacheNames = "0830",key = "#p0.id")
    User save(User user);
}
