package com.gamecoder.rpc;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * ServerInitializer
 *
 * @author Cuizw
 * @date 2016/8/29 0029
 */
public class ServerInitializer extends ChannelInitializer<SocketChannel> {
    private final RpcBootHandler handler;
    public ServerInitializer(RpcBootHandler handler){
        this.handler = handler;
    }


    @Override
    public void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new HttpObjectAggregator(65536));
        pipeline.addLast(new RpcHandler(handler.getHttpData()));

    }
}
