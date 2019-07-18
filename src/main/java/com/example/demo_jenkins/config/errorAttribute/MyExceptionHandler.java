package com.example.demo_jenkins.config.errorAttribute;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//如果返回的是Json格式的数据，
//可以使用@ResponseBody+@ControllerAdvice替换@RestControllerAdvice
@ControllerAdvice
public class MyExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    /**
     * 转发/error进行自适应响应效果处理
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class)
    public String handleException(Exception exception, HttpServletRequest request){
        //自定义异常错误信息
        Map<String,Object> map = new HashMap<>();
        //自定义异常
        if(exception instanceof MyException) {
            MyException sbexception = (MyException)exception;
            map.put("code",sbexception.getCode());
            map.put("msg",sbexception.getMessage());
        }else {
            logger.error("系统异常 {}",exception);
            map.put("code","-1");
            map.put("msg",exception.getMessage());
        }
        //传入我们自己的错误状态码  4xx 5xx
        //Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        request.setAttribute("javax.servlet.error.status_code",400);
        request.setAttribute("ext",map);
        //转发到/error
        return "forward:/error";
    }
}
