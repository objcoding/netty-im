package com.objcoding.netty.im.entity;

/**
 * @author zhangchenghui.dev@gmail.com
 * @since 2018/11/6
 */
public abstract class Packet {


    private Byte version = 1;

    public abstract Byte getCommand();

    public Byte getVersion() {
        return version;
    }

    public void setVersion(Byte version) {
        this.version = version;
    }
}
