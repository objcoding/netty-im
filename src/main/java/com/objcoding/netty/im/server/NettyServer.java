package com.objcoding.netty.im.server;

import com.objcoding.netty.im.server.handler.AuthHandler;
import com.objcoding.netty.im.server.handler.LoginRequestHandler;
import com.objcoding.netty.im.server.handler.MessageRequestHandler;
import com.objcoding.netty.im.codec.PacketDecoder;
import com.objcoding.netty.im.codec.PacketEncoder;
import com.objcoding.netty.im.util.Spliter;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * server
 *
 * @author zhangchenghui.dev@gmail.com
 * @since 2018/11/2
 */
public class NettyServer {

    public static void main(String[] args) {
        start();
    }

    private static final int PORT = 8081;


    private static void start() {
        // 1.创建线程模型
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        new ServerBootstrap()
                .group(bossGroup, workerGroup)
                // 2. 定义IO模型
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                // 3. 定义读写处理逻辑
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    public void initChannel(NioSocketChannel ch) {
                        // inBound，处理读数据的逻辑链
                        ch.pipeline().addLast(new Spliter());
                        ch.pipeline().addLast(new PacketDecoder());
                        ch.pipeline().addLast(new LoginRequestHandler());
                        ch.pipeline().addLast(new AuthHandler());
                        ch.pipeline().addLast(new MessageRequestHandler());
                        ch.pipeline().addLast(new PacketEncoder());

                        // outBound，处理写数据的逻辑链


                    }
                })
                .bind(PORT)
                .addListener((future) -> {
                    if (future.isSuccess()) {
                        System.out.println("端口绑定成功!");
                    } else {
                        System.out.println("端口绑定失败!");
                    }
                });
    }

}
