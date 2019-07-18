package com.example.demo_jenkins.dao.user;

import com.example.demo_jenkins.entity.user.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

    @Select("select * from s_user")
    public List<User> getUserList();
}
