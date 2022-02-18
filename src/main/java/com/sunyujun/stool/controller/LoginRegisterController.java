package com.sunyujun.stool.controller;

import com.sunyujun.stool.pojo.User;
import com.sunyujun.stool.service.impl.LoginServiceImpl;
import com.sunyujun.stool.service.impl.RegisterServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 1/16 14:48
 */
@Slf4j
//@CrossOrigin(origins = "${spring.consts.front-end-host}", allowCredentials = "true")
@RestController
public class LoginRegisterController {
    private static final Logger logger = LoggerFactory.getLogger(LoginRegisterController.class);

    @Autowired
    private LoginServiceImpl loginService;

    @PostMapping("/login")
    public User login(@RequestBody User loginUser,
                      HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        // 根据参数信息获取User对象
        User userByLogin = loginService.getUserByLogin(loginUser.getUsername(), loginUser.getPassword());
        // 查询用户失败
        if (userByLogin == null) {
            response.setStatus(401);
            return null;
        }
        // 将用户名放入session
        request.getSession().setAttribute("username", loginUser.getUsername());
        log.info("用户已登录：{}", userByLogin);
        // 保护一下？好像也没啥大用，
        userByLogin.setPassword("");
        return userByLogin;
    }

    @GetMapping("/logout")
    public void logout(@RequestParam String username, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Object name = session.getAttribute("username");
        log.info("用户{} -- 退出登录", name);
        if (name != null) {
            session.invalidate();
        } else {
            response.setStatus(500);
        }
    }

    @Autowired
    private RegisterServiceImpl registerService;

    @PostMapping("/register")
    public Boolean registerNormalUser(@RequestBody User registerUser, HttpServletResponse response) {
        logger.info("开始注册");
        System.out.println(registerUser);
        if (registerService.searchForUsername(registerUser.getUsername()) != null) {
            response.setStatus(888);
            return false;
        }
        int i = registerService.registerNormalUser(registerUser);
        if (i > 0) logger.info("注册成功");
        else logger.info("注册失败");
        return i > 0;
    }

    @GetMapping("/check_dup_name")
    public boolean checkDupName(@RequestParam(name = "username") String username) {
        // 查询username是否存在
        return registerService.searchForUsername(username) != null;
    }

}
