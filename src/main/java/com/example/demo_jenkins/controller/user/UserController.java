package com.example.demo_jenkins.controller.user;

import com.example.demo_jenkins.config.errorAttribute.MyException;
import com.example.demo_jenkins.entity.user.User;
import com.example.demo_jenkins.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("user")
@Api(description="用户基本信息操作API")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "list")
    @ApiOperation(value = "用户列表", notes = "根据姓名查询用户信息")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "age",value = "用户年龄",paramType = "form"),
            @ApiImplicitParam(name = "userName",value = "用户名称")
    })
    public List<User> getUserList(String age, String userName){
        return userService.getUserList();
    }

    @GetMapping(value = "ex/{id:\\d+}")
    @ApiOperation(value = "测试异常处理", notes = "这个是自定义异常")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户ID",paramType = "form"),
    })
    public User exUserList(@PathVariable String id){
        throw new MyException(100, "这个是自定义异常！");
    }

    @PostMapping(value = "add")
    @ApiOperation(value = "添加用户", notes = "新增用户")
    public void addUserList(@Valid @RequestBody User user){
        int i = 0;
        int b = 1/i;
    }


}
