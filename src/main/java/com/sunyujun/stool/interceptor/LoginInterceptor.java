package com.sunyujun.stool.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截需要登录的路径，检查username属性是否已经在对应的session中。
 * @author sunyujun
 * @version 0.0.0
 * @date 1/16 20:38
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        log.info("拦截器处理中，路径：{}", request.getRequestURL());
        String username = (String) request.getSession().getAttribute("username");
        if (username == null) {
            // 如果是OPTIONS请求，放行
            if ("OPTIONS".equals(request.getMethod())) return true;
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            log.info("未登录，拦截器返回401");
            return false;
        }
        log.info("请求通过，来自用户：{}",username);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {

    }
}
