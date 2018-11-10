package com.objcoding.netty.im.util;

import com.objcoding.netty.im.protocol.Attributes;
import io.netty.channel.Channel;
import io.netty.util.Attribute;

/**
 * 登录工具
 *
 * @author zhangchenghui.dev@gmail.com
 * @since 2018/11/6
 */
public class LoginUtil {

    public static void markAsLogin(Channel channel) {
        channel.attr(Attributes.LOGIN).set(true);
    }

    public static boolean hasLogin(Channel channel) {
        Attribute<Boolean> loginAttr = channel.attr(Attributes.LOGIN);
        return loginAttr.get() != null;
    }
}
