package com.example.demo_jenkins.entity.user;

import com.example.demo_jenkins.config.validator.MyValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@ApiModel(value = "用户对象:user")
public class User implements Serializable {

    @ApiModelProperty(value = "用户id")
    private String id;
    @ApiModelProperty(value = "用户名称",required = true)
    private String userName;
    @ApiModelProperty(value = "用户年龄",allowableValues = "0,1,2")
    private int age;

    public User(){

    }

    public User(String id, String userName, int age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NotBlank(message = "用户名不能为空")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @MyValidator(message = "这只是一个测试")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
