package com.objcoding.netty.im.service;

import com.objcoding.netty.im.dto.LoginRequest;
import com.objcoding.netty.im.protocol.LoginRequestPacket;
import com.objcoding.netty.im.util.SessionUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangchenghui.dev@gmail.com
 * @since 2018/11/7
 */
@Slf4j
@Service
public class LoginService {

    private static final int MAX_RETRY = 5;
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8081;

    public String login(Bootstrap bootstrap, LoginRequest loginRequest) {
        return login(bootstrap, loginRequest, HOST, PORT, MAX_RETRY);
    }

    private String login(Bootstrap bootstrap, LoginRequest loginRequest, String host, int port, int retry) {
        bootstrap.connect(host, port)
                .addListener(future -> {
                    if (future.isSuccess()) {
                        log.info("连接成功，启动控制台线程……");
                        Channel channel = ((ChannelFuture) future).channel();
                        // 连接成功之后, 保存登录session
                         connect(channel, loginRequest);
                    } else if (retry == 0) {
                        log.info("重试次数已用完，放弃连接！");
                    } else {
                        // 第几次重连
                        int order = (MAX_RETRY - retry) + 1;
                        // 本次重连的间隔
                        int delay = 1 << order;
                        log.info(new Date() + ": 连接失败，第" + order + "次重连……");
                        bootstrap.config().group().schedule(() -> login(bootstrap, loginRequest, host, port, retry - 1), delay, TimeUnit.SECONDS);
                    }
                });
        return "登录成功";
    }

    private boolean connect(Channel channel, LoginRequest loginRequest) {
        if (!SessionUtil.hasLogin(channel)) {
            LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
            loginRequestPacket.setUserName(loginRequest.getUserName());
            // 密码使用默认的
            loginRequestPacket.setPassword("123456");
            // 发送登录数据包
            channel.writeAndFlush(loginRequestPacket);
            return true;
        } else {
            return false;
        }
    }

}
