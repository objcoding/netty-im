package com.objcoding.netty.im.protocol;

import lombok.Data;

/**
 * @author zhangchenghui.dev@gmail.com
 * @since 2018/11/6
 */
@Data
public class LoginResponsePacket extends Packet {

    private String userId;

    private String userName;

    private String reason;

    private boolean success;

    @Override
    public Byte getCommand() {
        return null;
    }
}
