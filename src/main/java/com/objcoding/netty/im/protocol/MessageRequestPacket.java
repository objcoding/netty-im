package com.objcoding.netty.im.protocol;

import lombok.Data;

import static com.objcoding.netty.im.protocol.Command.MESSAGE_REQUEST;

/**
 * @author zhangchenghui.dev@gmail.com
 * @since 2018/11/6
 */
@Data
public class MessageRequestPacket extends Packet {

    private String message;

    private String toUserId;

    public MessageRequestPacket(String message, String toUserId) {
        this.message = message;
        this.toUserId = toUserId;
    }

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }

}
