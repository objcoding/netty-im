package com.objcoding.netty.im.protocol;

import lombok.Data;

import static com.objcoding.netty.im.protocol.Command.MESSAGE_RESPONSE;

/**
 * @author zhangchenghui.dev@gmail.com
 * @since 2018/11/6
 */
@Data
public class MessageResponsePacket extends Packet {

    private String message;

    private String fromUserId;

    private String fromUserName;

    @Override
    public Byte getCommand() {
        return MESSAGE_RESPONSE;
    }

}
