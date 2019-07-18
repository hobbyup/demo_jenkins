package com.example.demo_jenkins.config.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 目标方法执行前执行此方法
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("starttime",new Date().getTime());
        logger.info("进入拦截器..." );
        System.out.println();
        logger.info("拦截类名：" + ((HandlerMethod)handler).getBean().getClass().getSimpleName());
        logger.info("拦截方法名：" + ((HandlerMethod)handler).getMethod().getName());
        /*Object user = request.getSession().getAttribute("user");
        if (StringUtils.isEmpty(user)) {
            request.setAttribute("msg","没有权限请先登录");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }*/
        return true;
    }

    /**
     * 目标方法执行中执行此方法
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("拦截器中...");
        logger.info("耗时：" + (new Date().getTime() - (Long) request.getAttribute("starttime")));
    }

    /**
     * 目标方法执行后执行此方法
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("出拦截器...");
        logger.info("耗时：" + (new Date().getTime() - (Long) request.getAttribute("starttime")));
    }
}
