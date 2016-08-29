package com.gamecoder.core;

import io.netty.channel.ChannelHandlerContext;

/**
 * IWebSocketData
 *
 * @author Cuizw
 * @date 2016/8/29 0029
 */
public interface IWebSocketData {
    void onData(ChannelHandlerContext ctx, String data);
}
