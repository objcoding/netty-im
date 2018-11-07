package com.objcoding.netty.im.protocol;

/**
 * 指令
 *
 * @author zhangchenghui.dev@gmail.com
 * @since 2018/11/6
 */
public interface Command {

    Byte LOGIN_REQUEST = 1;

    Byte LOGIN_RESPONSE = 2;

    Byte MESSAGE_REQUEST = 3;

    Byte MESSAGE_RESPONSE = 4;

}
