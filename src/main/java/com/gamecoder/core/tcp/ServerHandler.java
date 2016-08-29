package com.gamecoder.core.tcp;

import com.gamecoder.core.IConnect;
import com.gamecoder.core.IData;
import com.gamecoder.core.IDisconnect;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * ServerHandler
 *
 * @author Cuizw
 * @date 2016/8/29 0029
 */
public class ServerHandler extends SimpleChannelInboundHandler<ServerMessage>{
    private IConnect connect;
    private IDisconnect disconnect;
    private IData data;

    public ServerHandler(IConnect connect, IDisconnect disconnect, IData data){
        this.connect = connect;
        this.disconnect = disconnect;
        this.data = data;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ServerMessage msg) throws Exception {
        data.onData(msg,ctx.channel());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        connect.onConnect(ctx.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        disconnect.onDisconnect(ctx.channel());
    }
}
