package com.objcoding.netty.im.protocol;

import lombok.Data;

import static com.objcoding.netty.im.protocol.Command.LOGIN_REQUEST;

/**
 * @author zhangchenghui.dev@gmail.com
 * @since 2018/11/6
 */
@Data
public class LoginRequestPacket extends Packet {

    private String userId;

    private String userName;

    private String password;

    @Override
    public Byte getCommand() {

        return LOGIN_REQUEST;
    }

}
