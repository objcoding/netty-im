package com.objcoding.netty.im.controller;

import com.objcoding.netty.im.dto.LoginRequest;
import com.objcoding.netty.im.service.LoginService;
import io.netty.bootstrap.Bootstrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangchenghui.dev@gmail.com
 * @since 2018/11/6
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private Bootstrap bootstrap;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return loginService.login(bootstrap, loginRequest);
    }

}
