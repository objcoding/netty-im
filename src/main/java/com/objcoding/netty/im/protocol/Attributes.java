package com.objcoding.netty.im.protocol;

import com.objcoding.netty.im.session.Session;
import io.netty.util.AttributeKey;

/**
 * 属性
 *
 * @author zhangchenghui.dev@gmail.com
 * @since 2018/11/6
 */
public interface Attributes {

    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");

    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");

}
