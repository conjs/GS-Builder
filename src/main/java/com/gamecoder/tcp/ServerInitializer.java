package com.gamecoder.tcp;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * ServerInitializer
 *
 * @author Cuizw
 * @date 2016/8/29 0029
 */
public class ServerInitializer extends ChannelInitializer<SocketChannel> {
    private final TcpBootHandler param;
    public ServerInitializer(TcpBootHandler param){
        this.param = param;
    }


    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new MessageCodec());
        pipeline.addLast(new ServerHandler(param.getConnect(),param.getDisconnect(),param.getData()));
    }
}
