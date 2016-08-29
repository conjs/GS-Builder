package com.gamecoder.core.websocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;

/**
 * ServerInitializer
 *
 * @author Cuizw
 * @date 2016/8/29 0029
 */
public class ServerInitializer extends ChannelInitializer<SocketChannel> {
    private final WebSocketBootHandler handler;
    public ServerInitializer( WebSocketBootHandler param){
        this.handler = param;
    }

    private static final String WEBSOCKET_PATH = "/websocket";


    @Override
    public void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new HttpObjectAggregator(65536));
        pipeline.addLast(new WebSocketServerProtocolHandler(WEBSOCKET_PATH, null, true));
        pipeline.addLast(new WebSocketHandler(handler.getConnect(), handler.getDisconnect(), handler.getWebSocketData()));
        pipeline.addLast(new WebHttpHandler(handler.getHttpData()));

    }
}
