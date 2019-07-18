package com.example.demo_jenkins.service.user.impl;

import com.example.demo_jenkins.config.redis.RedisUtil;
import com.example.demo_jenkins.dao.user.UserDao;
import com.example.demo_jenkins.entity.user.User;
import com.example.demo_jenkins.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    RedisUtil redisUtil;

    //@Cacheable(value = "user", key = "1", unless = "#result eq null ")
    @Override
    public List<User> getUserList() {
        List<User> userList = userDao.getUserList();
        //redisUtil.set("user",userList,10);
        return userList;
    }

}
