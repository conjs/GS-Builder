package com.gamecoder.boot;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

/**
 * MessageCodec
 *
 * @author Cuizw
 * @date 2016/8/29 0029
 */
public class MessageCodec extends io.netty.handler.codec.ByteToMessageCodec{
    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        if(msg instanceof ServerMessage){
            ServerMessage message = (ServerMessage)msg;
            out.writeBytes(message.pack());
        }
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List out) throws Exception {
        if(in.readableBytes()<4)
            return;
        int len = in.getInt(in.readerIndex());
        if(in.readableBytes()<len+6)
            return;
        int head = in.readInt();
        ByteBuf buf = Unpooled.buffer(head);
        in.readBytes(buf);
        out.add(new ServerMessage().unpack(buf));
    }
}
