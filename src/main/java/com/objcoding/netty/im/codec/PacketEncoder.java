package com.objcoding.netty.im.codec;

import com.objcoding.netty.im.protocol.Packet;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 编码器
 *
 * @author zhangchenghui.dev@gmail.com
 * @since 2018/11/7
 */
public class PacketEncoder extends MessageToByteEncoder<Packet> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, ByteBuf out) {
        ByteBufCodec.INSTANCE.encode(out, packet);
    }

}
