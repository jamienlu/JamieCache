package io.github.jamielu.jamiecache.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author jamieLu
 * @create 2024-06-25
 */
@Slf4j
public class JmCacheDecode extends ByteToMessageDecoder {
    AtomicLong counter = new AtomicLong();
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf bufIn, List<Object> dataOut) throws Exception {
        if (bufIn.readableBytes() <=0 ) return;
        int count = bufIn.readableBytes();
        int index = internalBuffer().readerIndex();
        log.info("count:" + count + ",index:" + index);
        byte[] datas = new byte[count];
        bufIn.readBytes(datas);
        String res = new String(datas);
        log.info("decode data:" + res);
        dataOut.add(res);
    }
}
