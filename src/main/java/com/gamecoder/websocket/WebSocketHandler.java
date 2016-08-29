package com.gamecoder.websocket;

import com.gamecoder.core.IConnect;
import com.gamecoder.core.IDisconnect;
import com.gamecoder.core.IWebSocketData;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

import java.io.IOException;

/**
 * WebSocketHandler
 *
 * @author Cuizw
 * @date 2016/8/29 0029
 */
public class WebSocketHandler extends SimpleChannelInboundHandler<WebSocketFrame> {
    private IConnect connect;
    private IDisconnect disconnect;
    private IWebSocketData webSocketData;

    public WebSocketHandler(IConnect connect,IDisconnect disconnect,IWebSocketData webSocketData){
        this.connect = connect;
        this.disconnect = disconnect;
        this.webSocketData = webSocketData;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame frame) throws Exception {
        if (frame instanceof TextWebSocketFrame) {
            String request = ((TextWebSocketFrame) frame).text();
            webSocketData.onData(ctx,request);
        }else if(frame instanceof PingWebSocketFrame){
            ctx.channel().write(new PongWebSocketFrame(frame.content()));
        }
        else {
            String message = "unsupported frame type: " + frame.getClass().getName();
            throw new UnsupportedOperationException(message);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        connect.onConnect(ctx.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        ChannelPipeline pipeline = ctx.pipeline();
        if (pipeline != null) {
            try {
                while (pipeline.last() != null) {
                    pipeline.removeLast();
                }
                ctx.channel().close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if(disconnect!=null)
            disconnect.onDisconnect(ctx.channel());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable e) throws Exception {
        if(e.getCause() instanceof IOException){}
        else {
            e.getCause().printStackTrace();
            ctx.channel().close();
        }
    }
}
