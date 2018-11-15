package com.objcoding.netty.im.serializer;


import com.alibaba.fastjson.JSON;

/**
 * @author zhangchenghui.dev@gmail.com
 * @since 2018/11/6
 */
public class JSONSerializer implements Serializer {

    @Override
    public byte getSerializerAlgorithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}
