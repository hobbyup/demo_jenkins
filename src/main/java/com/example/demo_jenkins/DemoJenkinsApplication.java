package com.example.demo_jenkins;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching //开启缓存注解
@MapperScan("com.example.demo_jenkins.dao") //开启mybatis注解扫描
@SpringBootApplication
public class DemoJenkinsApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoJenkinsApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoJenkinsApplication.class, args);
    }

}
